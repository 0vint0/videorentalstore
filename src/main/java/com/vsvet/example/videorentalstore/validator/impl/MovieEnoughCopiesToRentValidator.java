package com.vsvet.example.videorentalstore.validator.impl;

import com.vsvet.example.videorentalstore.domain.Movie;
import com.vsvet.example.videorentalstore.repository.MovieRepository;
import com.vsvet.example.videorentalstore.validator.AbstractConstraintValidator;
import com.vsvet.example.videorentalstore.validator.MovieEnoughCopiesToRent;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieEnoughCopiesToRentValidator extends AbstractConstraintValidator<MovieEnoughCopiesToRent, Long> {

    private MovieEnoughCopiesToRent movieEnoughCopiesToRent;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void initialize(MovieEnoughCopiesToRent movieEnoughCopiesToRent) {
        this.movieEnoughCopiesToRent = movieEnoughCopiesToRent;
    }

    @Override
    protected boolean isValid(Long value) {
        Movie movie = movieRepository.findOne(value);
        return movie == null || movie.getNumberOfRentCopies() < movie.getNumberOfCopies();
    }

    @Override
    protected String getValidationMessage(Long value) {
        return movieEnoughCopiesToRent.message();
    }


}
