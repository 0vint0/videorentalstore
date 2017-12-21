package com.vsvet.example.videorentalstore;

import com.vsvet.example.videorentalstore.AbstractTest;
import com.vsvet.example.videorentalstore.config.ValidationConfig;
import com.vsvet.example.videorentalstore.domain.Movie;
import com.vsvet.example.videorentalstore.repository.MovieRepository;
import com.vsvet.example.videorentalstore.service.ErrorMessageMatcher;
import com.vsvet.example.videorentalstore.service.PriceCalculationService;
import com.vsvet.example.videorentalstore.service.impl.PriceCalculationServiceTestConfig;
import com.vsvet.example.videorentalstore.validator.MovieIdsExist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static com.vsvet.example.videorentalstore.BeanTestUtils.*;
/**
 * Tests only validation layer
 */
@ContextConfiguration(classes = {PriceCalculationServiceTestConfig.class,ValidationConfig.class})
public class PriceCalculationServiceTest extends AbstractTest{

    private Movie movie1,movie2;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private PriceCalculationService toTest;

    @Before
    public void setup(){
        prepareMovies();
        prepareMovieRepository();
    }

    @After
    public void cleanup(){
        reset(movieRepository);
    }

    //test calculate validation methods
    @Test
    public void testCalculateWithSuccess(){
        toTest.calculate(Arrays.asList(movie1,movie2), 2);
    }

    @Test
    public void testCalculateFailedPeriodIsNotPositive(){
        thrown.expect(ErrorMessageMatcher.matches("Field 'period' must be greater than 0"));
        toTest.calculate(Arrays.asList(movie1,movie2), -2);
    }

    @Test
    public void testCalculateFailedNoMovieFound(){
        thrown.expect(ErrorMessageMatcher.matches("Movie with '["+MOVIE_ID_1+", "+MOVIE_ID_2+"]' ids do not exist!"));
        when(movieRepository.findOne(MOVIE_ID_1)).thenReturn(null);
        toTest.calculate(Arrays.asList(movie1,movie2), 2);
    }
    //

    private void prepareMovies(){
        movie1 = movie1();
        movie1.setMoviePrice(moviePrice1());
        movie2 = movie2();
        movie2.setMoviePrice(moviePrice2());
    }

    private void prepareMovieRepository(){
        when(movieRepository.findOne(MOVIE_ID_1)).thenReturn(movie1);
        when(movieRepository.findOne(MOVIE_ID_2)).thenReturn(movie2);

    }
}
