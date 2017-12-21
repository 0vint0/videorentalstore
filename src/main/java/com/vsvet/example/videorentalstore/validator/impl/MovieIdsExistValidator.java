package com.vsvet.example.videorentalstore.validator.impl;

import com.vsvet.example.videorentalstore.repository.MovieRepository;
import com.vsvet.example.videorentalstore.validator.AbstractConstraintValidator;
import com.vsvet.example.videorentalstore.validator.MovieIdsExist;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.List;

public class MovieIdsExistValidator extends AbstractConstraintValidator<MovieIdsExist, List<Long>> {

    private MovieIdsExist movieIdExist;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void initialize(MovieIdsExist movieIdExist) {
        this.movieIdExist = movieIdExist;
    }

    @Override
    protected boolean isValid(List<Long> value) {
        return value==null||value.stream().allMatch(i->movieRepository.findOne(i) != null);
    }

    @Override
    protected String getValidationMessage(List<Long> value) {
        return MessageFormat.format(movieIdExist.message(), value);
    }


}
