package com.vsvet.example.videorentalstore.controller;

import com.vsvet.example.videorentalstore.service.MovieService;
import com.vsvet.example.videorentalstore.view.MovieView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    private final MovieService movieService;

    private final RestResponses restResponses = RestResponses.json();

    public MovieController(MovieService movieService) {
        this.movieService = Objects.requireNonNull(movieService);
    }

    @ApiOperation(value = "Returns all movies in the store.", notes = "Returns all movies in the store.")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal server error!"),
            @ApiResponse(code = 200, message = "Success!")})
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<MovieView>> findAll() {
        LOGGER.info("Called findAll movies.");
        return restResponses.ok(movieService.findAll());
    }

}
