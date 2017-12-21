package com.vsvet.example.videorentalstore.service.impl;

import com.vsvet.example.videorentalstore.AbstractTest;
import com.vsvet.example.videorentalstore.domain.Client;
import com.vsvet.example.videorentalstore.domain.Movie;
import com.vsvet.example.videorentalstore.domain.MovieRental;
import com.vsvet.example.videorentalstore.domain.MovieRentalStatus;
import com.vsvet.example.videorentalstore.repository.ClientRepository;
import com.vsvet.example.videorentalstore.repository.MovieRentalRepository;
import com.vsvet.example.videorentalstore.repository.MovieRepository;
import com.vsvet.example.videorentalstore.service.MovieRentalService;
import com.vsvet.example.videorentalstore.service.PriceCalculationService;
import com.vsvet.example.videorentalstore.view.MovieRentalView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.vsvet.example.videorentalstore.BeanTestUtils.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = MovieRentalServiceTestConfig.class)
public class MovieRentalServiceImplTest extends AbstractTest {

    private static final BigDecimal CALCULATED_PRICE = BigDecimal.valueOf(34);
    private static final Integer RENT_PERIOD = 3;

    private Movie movie1, movie2;
    private MovieRentalView movieRentalView;
    private Client client;

    private MovieRental movieRental;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieRentalRepository movieRentalRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PriceCalculationService priceCalculationService;

    @Captor
    private ArgumentCaptor<MovieRental> movieRentalCaptor;
    @Captor
    private ArgumentCaptor<Client> clientCaptor;
    @Captor
    private ArgumentCaptor<List<Movie>> movieCaptor;

    @Autowired
    private MovieRentalService toTest;

    @Before
    public void setup() {
        client = client();
        prepareMovieRentalView();
        prepareMovies();
        prepareClientRepository();
        prepareMovieRepository();
        prepareMovieRentalRepository();
        preparePriceCalculationService();

    }

    @After
    public void cleanup() {
        reset(movieRepository, movieRentalRepository, clientRepository, priceCalculationService);
    }


    @Test
    public void testRentMoviesCreateEntryInDbWithExpectedValues() {
        toTest.rentMovies(movieRentalView);
        verify(movieRentalRepository).save(movieRentalCaptor.capture());
        assertEquals(CALCULATED_PRICE, movieRentalCaptor.getValue().getOriginalPrice());
        assertEquals(CLIENT_ID, movieRentalCaptor.getValue().getClientId());
        assertEquals(RENT_PERIOD, movieRentalCaptor.getValue().getOriginalPeriod());
        assertEquals(MovieRentalStatus.RENTED, movieRentalCaptor.getValue().getStatus());
        assertEquals(Arrays.asList(movie1, movie2), movieRentalCaptor.getValue().getMovies());
    }

    @Test
    public void testRentMoviesUpdateClientBalance() {
        toTest.rentMovies(movieRentalView);
        verify(clientRepository).save(clientCaptor.capture());
        assertEquals(CLIENT_BALANCE.subtract(CALCULATED_PRICE), clientCaptor.getValue().getBalance());
    }

    @Test
    public void testRentMoviesUpdateNumberOfRentCopies() {
        toTest.rentMovies(movieRentalView);
        verify(movieRepository).save(movieCaptor.capture());
        assertEquals(Long.valueOf(MOVIE_NUMBER_OF_RENT_COPIES_1 + 1), movieCaptor.getValue().get(0).getNumberOfRentCopies());
        assertEquals(Long.valueOf(MOVIE_NUMBER_OF_RENT_COPIES_2 + 1), movieCaptor.getValue().get(1).getNumberOfRentCopies());
    }

    private void prepareMovieRentalView() {
        movieRentalView = new MovieRentalView();
        movieRentalView.setClientId(CLIENT_ID);
        movieRentalView.setNumberOfDays(RENT_PERIOD);
        movieRentalView.setMovieIds(Arrays.asList(MOVIE_ID_1, MOVIE_ID_2));
        movieRentalView.setPrice(CALCULATED_PRICE);

        movieRental = new MovieRental();
        movieRental.setOriginalPeriod(RENT_PERIOD);
        movieRental.setOriginalPrice(CALCULATED_PRICE);
    }

    private void prepareMovies() {
        movie1 = movie1();
        movie1.setMoviePrice(moviePrice1());
        movie2 = movie2();
        movie2.setMoviePrice(moviePrice2());
    }


    private void prepareMovieRepository() {
        when(movieRepository.findAllByIdIn(anyList())).thenReturn(Arrays.asList(movie1, movie2));
        when(movieRepository.findOne(MOVIE_ID_1)).thenReturn(movie1);
        when(movieRepository.findOne(MOVIE_ID_2)).thenReturn(movie2);
    }

    private void prepareClientRepository() {
        when(clientRepository.findOne(CLIENT_ID)).thenReturn(client);
        when(clientRepository.save(any(Client.class))).thenReturn(client);
    }

    private void prepareMovieRentalRepository() {
        when(movieRentalRepository.save(any(MovieRental.class))).thenReturn(movieRental);
    }

    private void preparePriceCalculationService() {
        when(priceCalculationService.calculate(anyList(), anyInt())).thenReturn(CALCULATED_PRICE);
    }

}