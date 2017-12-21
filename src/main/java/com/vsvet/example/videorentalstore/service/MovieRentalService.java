package com.vsvet.example.videorentalstore.service;

import com.vsvet.example.videorentalstore.domain.MovieRentalStatus;
import com.vsvet.example.videorentalstore.validator.ClientHasEnoughBalance;
import com.vsvet.example.videorentalstore.validator.MovieRentalIdExistWithStatus;
import com.vsvet.example.videorentalstore.view.MovieRentalView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface MovieRentalService {

    MovieRentalView calculatePrice(@Valid MovieRentalView  view);

    MovieRentalView rentMovies(@Valid @ClientHasEnoughBalance MovieRentalView view);

    MovieRentalView returnMovies(@MovieRentalIdExistWithStatus(status = MovieRentalStatus.RENTED)  Long rentalIdentifier);

}
