package com.vsvet.example.videorentalstore.controller;

import com.vsvet.example.videorentalstore.service.MovieRentalService;
import com.vsvet.example.videorentalstore.view.MovieRentalView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/movies/rentals")
public class MovieRentalController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieRentalController.class);

    private final MovieRentalService movieRentalService;

    private final RestResponses restResponses = RestResponses.json();

    public MovieRentalController(MovieRentalService movieRentalService) {
        this.movieRentalService = Objects.requireNonNull(movieRentalService);
    }

    @ApiOperation(value = "Calculate price for movies", notes = "Returns all movies in the store.")
    @ApiResponses(value = {
            @ApiResponse(code = 412, message = "Validation failed!"),
            @ApiResponse(code = 500, message = "Internal server error!"),
            @ApiResponse(code = 200, message = "Success!")})
    @RequestMapping(value = "/price", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<MovieRentalView> calculatePrice(@RequestBody MovieRentalView view) {
        LOGGER.info("Called calculatePrice for movies {}.", view);
        return restResponses.ok(movieRentalService.calculatePrice(view));
    }

    @ApiOperation(value = "Rent a list of movies.", notes = "Rent a list of movies.")
    @ApiResponses(value = {
            @ApiResponse(code = 412, message = "Validation failed!"),
            @ApiResponse(code = 500, message = "Internal server error!"),
            @ApiResponse(code = 200, message = "Success!")})
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<MovieRentalView> rentMovies(@RequestBody MovieRentalView view) {
        LOGGER.info("Called rentMovies for movies {}.", view);
        return restResponses.ok(movieRentalService.rentMovies(view));
    }

    @ApiOperation(value = "Return rent of list of movies.", notes = "Return rent of list of movies.")
    @ApiResponses(value = {
            @ApiResponse(code = 412, message = "Validation failed!"),
            @ApiResponse(code = 500, message = "Internal server error!"),
            @ApiResponse(code = 200, message = "Success!")})
    @RequestMapping(value = "/{rentalIdentification}", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<MovieRentalView> returnMovies(@PathVariable Long rentalIdentification) {
        LOGGER.info("Called return {} rent.", rentalIdentification);
        return restResponses.ok(movieRentalService.returnMovies(rentalIdentification));
    }


}
