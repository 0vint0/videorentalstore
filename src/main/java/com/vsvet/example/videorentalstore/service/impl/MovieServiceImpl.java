package com.vsvet.example.videorentalstore.service.impl;

import com.vsvet.example.videorentalstore.repository.MovieRepository;
import com.vsvet.example.videorentalstore.service.MovieService;
import com.vsvet.example.videorentalstore.view.MovieView;
import com.vsvet.example.videorentalstore.view.converter.MovieConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = Objects.requireNonNull(movieRepository);
    }

    @Override
    public List<MovieView> findAll() {
        MovieConverter movieConverter = new MovieConverter();
        return movieRepository.findAll()
                .stream()
                .map(movieConverter::convert)
                .collect(Collectors.toList());
    }
}
