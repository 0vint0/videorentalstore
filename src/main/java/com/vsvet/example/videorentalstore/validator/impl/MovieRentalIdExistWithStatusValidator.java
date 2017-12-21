package com.vsvet.example.videorentalstore.validator.impl;

import com.vsvet.example.videorentalstore.domain.MovieRental;
import com.vsvet.example.videorentalstore.repository.MovieRentalRepository;
import com.vsvet.example.videorentalstore.validator.AbstractConstraintValidator;
import com.vsvet.example.videorentalstore.validator.MovieRentalIdExistWithStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;

public class MovieRentalIdExistWithStatusValidator extends AbstractConstraintValidator<MovieRentalIdExistWithStatus, Long> {

    private MovieRentalIdExistWithStatus movieRentalIdExist;

    @Autowired
    private MovieRentalRepository movieRentalRepository;

    @Override
    public void initialize(MovieRentalIdExistWithStatus movieRentalIdExist) {
        this.movieRentalIdExist = movieRentalIdExist;
    }

    @Override
    protected boolean isValid(Long value) {
        MovieRental movieRental = movieRentalRepository.findOne(value);
        return movieRental != null && movieRental.getStatus() == movieRentalIdExist.status();
    }

    @Override
    protected String getValidationMessage(Long value) {
        return MessageFormat.format(movieRentalIdExist.message(), value, movieRentalIdExist.status());
    }


}
