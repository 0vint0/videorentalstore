package com.vsvet.example.videorentalstore.service.impl;

import com.vsvet.example.videorentalstore.AbstractTest;
import com.vsvet.example.videorentalstore.domain.Movie;
import com.vsvet.example.videorentalstore.service.PriceCalculationService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.util.Arrays;

import static com.vsvet.example.videorentalstore.BeanTestUtils.*;
import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = PriceCalculationServiceTestConfig.class)
public class PriceCalculationServiceImplTest extends AbstractTest {

    private Movie movie1, movie2;

    @Autowired
    private PriceCalculationService toTest;

    @Before
    public void setup() {
        prepareMovies();
        toTest = new PriceCalculationServiceImpl();
    }

    @Test
    public void testCalculatePriceForMoviesForOneDayPeriod() {
        BigDecimal expected = MOVIE_PRICE_PRICE_1.add(MOVIE_PRICE_PRICE_2);
        BigDecimal actual = toTest.calculate(Arrays.asList(movie1,movie2), 1);
        assertEquals(expected,actual );
    }

    @Test
    public void testCalculatePriceForMoviesForMoreThanOneDayPeriod(){
        BigDecimal expected = MOVIE_PRICE_PRICE_1.multiply(BigDecimal.valueOf(2)).add(MOVIE_PRICE_PRICE_2);
        BigDecimal actual = toTest.calculate(Arrays.asList(movie1,movie2), 2);
        assertEquals(expected,actual );
    }

    private void prepareMovies() {
        movie1 = movie1();
        movie2 = movie2();

        movie1.setMoviePrice(moviePrice1());
        movie2.setMoviePrice(moviePrice2());
    }

}