package com.vsvet.example.videorentalstore.service;

import com.vsvet.example.videorentalstore.view.MovieView;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface MovieService {

    List<MovieView> findAll();

}
