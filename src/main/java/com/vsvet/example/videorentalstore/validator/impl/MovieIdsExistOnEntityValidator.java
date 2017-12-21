package com.vsvet.example.videorentalstore.validator.impl;

import com.vsvet.example.videorentalstore.domain.Movie;
import com.vsvet.example.videorentalstore.repository.MovieRepository;
import com.vsvet.example.videorentalstore.validator.AbstractConstraintValidator;
import com.vsvet.example.videorentalstore.validator.MovieIdsExist;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public class MovieIdsExistOnEntityValidator extends AbstractConstraintValidator<MovieIdsExist, List<Movie>> {

    private MovieIdsExist movieIdExist;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void initialize(MovieIdsExist movieIdExist) {
        this.movieIdExist = movieIdExist;
    }

    @Override
    protected boolean isValid(List<Movie> value) {
        return value == null || value.stream().allMatch(i -> movieRepository.findOne(i.getId()) != null);
    }

    @Override
    protected String getValidationMessage(List<Movie> value) {
        return MessageFormat.format(movieIdExist.message(),value!=null? value.stream().map(m -> m.getId()).collect(Collectors.toList()):null);
    }


}
