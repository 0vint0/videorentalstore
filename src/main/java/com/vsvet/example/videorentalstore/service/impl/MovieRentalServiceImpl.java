package com.vsvet.example.videorentalstore.service.impl;

import com.vsvet.example.videorentalstore.concurrent.RetryConcurrentOperation;
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
import com.vsvet.example.videorentalstore.view.converter.MovieRentalConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class MovieRentalServiceImpl implements MovieRentalService {

    private final MovieRepository movieRepository;

    private final MovieRentalRepository movieRentalRepository;

    private final ClientRepository clientRepository;

    private final PriceCalculationService priceCalculationService;

    public MovieRentalServiceImpl(MovieRepository movieRepository,
                                  PriceCalculationService priceCalculationService,
                                  MovieRentalRepository movieRentalRepository,
                                  ClientRepository clientRepository) {
        this.movieRepository = Objects.requireNonNull(movieRepository);
        this.priceCalculationService = Objects.requireNonNull(priceCalculationService);
        this.movieRentalRepository = Objects.requireNonNull(movieRentalRepository);
        this.clientRepository = Objects.requireNonNull(clientRepository);
    }


    @Override
    public MovieRentalView calculatePrice(MovieRentalView view) {
        view.setPrice(getPrice(view));
        return view;
    }

    @RetryConcurrentOperation(exception = {OptimisticLockException.class, PersistenceException.class}, retries = 2)
    @Override
    public MovieRentalView rentMovies(MovieRentalView view) {
        MovieRental movieRental = saveMovieRental(view);
        subtractClientBalance(view.getClientId(), movieRental.getOriginalPrice());
        incrementMovieRentNumber(view, 1);
        view.setPrice(movieRental.getOriginalPrice());
        view.setId(movieRental.getId());
        return view;
    }

    private BigDecimal getPrice(MovieRentalView view) {
        return priceCalculationService.calculate(movieRepository.findAllByIdIn(view.getMovieIds()), view.getNumberOfDays());
    }

    private BigDecimal subtractClientBalance(Long clientId, BigDecimal price) {
        Client client = clientRepository.findOne(clientId);
        client.setBalance(client.getBalance().subtract(price));
        return clientRepository.save(client).getBalance();
    }

    private MovieRental saveMovieRental(MovieRentalView view) {
        MovieRental movieRental = new MovieRental();
        movieRental.setOriginalPrice(getPrice(view));
        movieRental.setOriginalPeriod(view.getNumberOfDays());
        movieRental.setClientId(view.getClientId());
        movieRental.setStatus(MovieRentalStatus.RENTED);
        movieRepository.findAllByIdIn(view.getMovieIds())
                .stream().forEach(movieRental.getMovies()::add);
        return movieRentalRepository.save(movieRental);
    }

    @RetryConcurrentOperation(exception = {OptimisticLockException.class, PersistenceException.class}, retries = 2)
    @Override
    public MovieRentalView returnMovies(Long rentalIdentifier) {
        MovieRental movieRental = movieRentalRepository.findOne(rentalIdentifier);
        movieRental.setStatus(MovieRentalStatus.RETURNED);
        Integer actualPeriod = Long.valueOf(Duration.between(movieRental.getCreatedDate(), Instant.now()).toDays()).intValue();
        movieRental.setActualPeriod(actualPeriod);
        movieRental.setActualPrice(getActualPrice(movieRental));
        incrementMovieRentNumber(movieRental.getMovies(), -1);
        return new MovieRentalConverter().convert(movieRental);
    }

    private BigDecimal getActualPrice(MovieRental movieRental) {
        if (movieRental.getActualPeriod() > movieRental.getOriginalPeriod()) {
            return priceCalculationService.calculate(movieRental.getMovies(), movieRental.getActualPeriod());
        } else {
            return movieRental.getOriginalPrice();
        }
    }

    private void incrementMovieRentNumber(MovieRentalView view, Integer copyNumber) {
        incrementMovieRentNumber(movieRepository.findAllByIdIn(view.getMovieIds()), copyNumber);
    }

    private void incrementMovieRentNumber(List<Movie> movies, Integer copyNumber) {
        movieRepository.save(
                movies
                        .stream()
                        .peek(m -> m.setNumberOfRentCopies(m.getNumberOfRentCopies() + copyNumber))
                        .collect(Collectors.toList())
        );
    }
}
