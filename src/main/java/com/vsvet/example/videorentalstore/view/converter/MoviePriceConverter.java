package com.vsvet.example.videorentalstore.view.converter;

import com.google.common.base.Converter;
import com.vsvet.example.videorentalstore.domain.MoviePrice;
import com.vsvet.example.videorentalstore.view.MoviePriceView;
import com.vsvet.example.videorentalstore.view.MovieTypeView;

public class MoviePriceConverter extends Converter<MoviePrice, MoviePriceView> {
    @Override
    protected MoviePriceView doForward(MoviePrice moviePrice) {
        MoviePriceView view = new MoviePriceView();
        view.setCreatedDate(moviePrice.getCreatedDate());
        view.setModifiedDate(moviePrice.getModifiedDate());
        view.setMovieType(MovieTypeView.valueOf(moviePrice.getMovieType().name()));
        view.setPrice(moviePrice.getPrice());
        view.setStartPeriod(moviePrice.getStartPeriod());
        return view;
    }

    @Override
    protected MoviePrice doBackward(MoviePriceView moviePriceView) {
        throw new UnsupportedOperationException();
    }
}
