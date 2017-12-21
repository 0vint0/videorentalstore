package com.vsvet.example.videorentalstore.view.converter;

import com.google.common.base.Converter;
import com.vsvet.example.videorentalstore.domain.MovieRental;
import com.vsvet.example.videorentalstore.view.MovieRentalView;

import java.util.stream.Collectors;

public class MovieRentalConverter extends Converter<MovieRental, MovieRentalView> {

    @Override
    protected MovieRentalView doForward(MovieRental movieRental) {
        MovieRentalView view = new MovieRentalView();
        view.setId(movieRental.getId());
        view.setPrice(movieRental.getOriginalPrice());
        if (movieRental.getActualPrice().compareTo(movieRental.getOriginalPrice()) > 0) {
            view.setComplimentPrice(movieRental.getActualPrice().subtract(movieRental.getOriginalPrice()));
        }
        view.setClientId(movieRental.getClientId());
        view.setNumberOfDays(movieRental.getActualPeriod());
        view.setMovieIds(
                movieRental.getMovies().stream().map(m -> m.getId()).collect(Collectors.toList())
        );
        return view;
    }

    @Override
    protected MovieRental doBackward(MovieRentalView movieRentalView) {
        throw new UnsupportedOperationException();
    }
}
