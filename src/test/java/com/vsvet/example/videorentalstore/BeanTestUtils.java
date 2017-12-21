package com.vsvet.example.videorentalstore;

import com.vsvet.example.videorentalstore.domain.Client;
import com.vsvet.example.videorentalstore.domain.Movie;
import com.vsvet.example.videorentalstore.domain.MoviePrice;
import com.vsvet.example.videorentalstore.domain.MovieType;

import java.math.BigDecimal;
import java.time.Instant;

public class BeanTestUtils {
    public static final Long CLIENT_ID = 12l;
    public static final BigDecimal CLIENT_BALANCE = BigDecimal.valueOf(200);

    public static final Long MOVIE_ID_1 = 12l;
    public static final String MOVIE_TITLE_1 = "title1";
    public static final String MOVIE_DESCRIPTION_1 = "dddd";
    public static final String MOVIE_DIRECTOR_1 = " Masser";
    public static final Long MOVIE_NUMBER_OF_COPIES_1 = 34l;
    public static final Long MOVIE_NUMBER_OF_RENT_COPIES_1 = 4555l;
    public static final Instant MOVIE_RELEASE_DATE_1 = Instant.now();
    public static final Instant MOVIE_CREATED_DATE_1 = Instant.now();
    public static final Instant MOVIE_MODIFIED_DATE_1 = Instant.now();
    public static final MovieType MOVIE_TYPE_1 = MovieType.NewRelease;

    public static final Long MOVIE_ID_2 = 1222l;
    public static final String MOVIE_TITLE_2 = "title2";
    public static final String MOVIE_DESCRIPTION_2 = "eeee";
    public static final String MOVIE_DIRECTOR_2 = " MAder";
    public static final Long MOVIE_NUMBER_OF_COPIES_2 = 14l;
    public static final Long MOVIE_NUMBER_OF_RENT_COPIES_2 = 45l;
    public static final Instant MOVIE_RELEASE_DATE_2 = Instant.now();
    public static final Instant MOVIE_CREATED_DATE_2 = Instant.now();
    public static final Instant MOVIE_MODIFIED_DATE_2 = Instant.now();
    public static final MovieType MOVIE_TYPE_2 = MovieType.Regular;

    public static final MovieType MOVIE_PRICE_TYPE_1 = MovieType.NewRelease;
    public static final BigDecimal MOVIE_PRICE_PRICE_1 = BigDecimal.valueOf(40);
    public static final Integer MOVIE_PRICE_START_PERIOD_1 = 1;

    public static final MovieType MOVIE_PRICE_TYPE_2 = MovieType.Regular;
    public static final BigDecimal MOVIE_PRICE_PRICE_2 = BigDecimal.valueOf(30);
    public static final Integer MOVIE_PRICE_START_PERIOD_2 = 3;

    public static Movie movie1() {
        Movie movie = new Movie();
        movie.setId(MOVIE_ID_1);
        movie.setTitle(MOVIE_TITLE_1);
        movie.setDescription(MOVIE_DESCRIPTION_1);
        movie.setDirector(MOVIE_DIRECTOR_1);
        movie.setNumberOfCopies(MOVIE_NUMBER_OF_COPIES_1);
        movie.setNumberOfRentCopies(MOVIE_NUMBER_OF_RENT_COPIES_1);
        movie.setReleaseDate(MOVIE_RELEASE_DATE_1);
        movie.setMovieType(MOVIE_TYPE_1);
        movie.setCreatedDate(MOVIE_CREATED_DATE_1);
        movie.setModifiedDate(MOVIE_MODIFIED_DATE_1);
        return movie;
    }

    public static Movie movie2() {
        Movie movie2 = new Movie();
        movie2.setId(MOVIE_ID_2);
        movie2.setTitle(MOVIE_TITLE_2);
        movie2.setDescription(MOVIE_DESCRIPTION_2);
        movie2.setDirector(MOVIE_DIRECTOR_2);
        movie2.setNumberOfCopies(MOVIE_NUMBER_OF_COPIES_2);
        movie2.setNumberOfRentCopies(MOVIE_NUMBER_OF_RENT_COPIES_2);
        movie2.setReleaseDate(MOVIE_RELEASE_DATE_2);
        movie2.setMovieType(MOVIE_TYPE_2);
        movie2.setCreatedDate(MOVIE_CREATED_DATE_2);
        movie2.setModifiedDate(MOVIE_MODIFIED_DATE_2);
        return movie2;
    }


    public static MoviePrice moviePrice1() {
        MoviePrice moviePrice = new MoviePrice();
        moviePrice.setStartPeriod(MOVIE_PRICE_START_PERIOD_1);
        moviePrice.setPrice(MOVIE_PRICE_PRICE_1);
        moviePrice.setMovieType(MOVIE_PRICE_TYPE_1);
        return moviePrice;
    }

    public static MoviePrice moviePrice2() {
        MoviePrice moviePrice = new MoviePrice();
        moviePrice.setStartPeriod(MOVIE_PRICE_START_PERIOD_2);
        moviePrice.setPrice(MOVIE_PRICE_PRICE_2);
        moviePrice.setMovieType(MOVIE_PRICE_TYPE_2);
        return moviePrice;
    }

    public static Client client(){
        Client client  = new Client();
        client.setId(CLIENT_ID);
        client.setBalance(CLIENT_BALANCE);
        return client;
    }
}
