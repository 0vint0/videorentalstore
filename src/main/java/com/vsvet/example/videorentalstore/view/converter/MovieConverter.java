package com.vsvet.example.videorentalstore.view.converter;

import com.google.common.base.Converter;
import com.vsvet.example.videorentalstore.domain.Movie;
import com.vsvet.example.videorentalstore.domain.MovieType;
import com.vsvet.example.videorentalstore.view.MovieTypeView;
import com.vsvet.example.videorentalstore.view.MovieView;

public class MovieConverter extends Converter<Movie, MovieView> {
    @Override
    protected MovieView doForward(Movie movie) {
        MovieView view = new MovieView();
        view.setId(movie.getId());
        view.setTitle(movie.getTitle());
        view.setDirector(movie.getDirector());
        view.setNumberOfCopies(movie.getNumberOfCopies());
        view.setNumberOfRentCopies(movie.getNumberOfRentCopies());
        view.setMovieType(MovieTypeView.valueOf(movie.getMovieType().name()));
        view.setDescription(movie.getDescription());
        view.setReleaseDate(movie.getReleaseDate());
        view.setCreatedDate(movie.getCreatedDate());
        view.setModifiedDate(movie.getModifiedDate());
        view.setPrice(new MoviePriceConverter().convert(movie.getMoviePrice()));
        return view;
    }

    @Override
    protected Movie doBackward(MovieView movieView) {
        Movie movie = new Movie();
        movie.setTitle(movieView.getTitle());
        movie.setDirector(movieView.getDirector());
        movie.setNumberOfCopies(movieView.getNumberOfCopies());
        movie.setMovieType(MovieType.valueOf(movieView.getMovieType().name()));
        movie.setDescription(movieView.getDescription());
        movie.setReleaseDate(movieView.getReleaseDate());
        return movie;
    }
}
