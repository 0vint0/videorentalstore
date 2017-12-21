package com.vsvet.example.videorentalstore.controller;

import com.vsvet.example.videorentalstore.service.ClientService;
import com.vsvet.example.videorentalstore.view.ClientView;
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
@RequestMapping(value = "/clients")
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    private final ClientService clientService;

    private final RestResponses restResponses = RestResponses.json();

    public ClientController(ClientService clientService) {
        this.clientService = Objects.requireNonNull(clientService);
    }

    @ApiOperation(value = "Returns all store clients.", notes = "Returns all store clients.")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "internal server error!"),
            @ApiResponse(code = 200, message = "Success!")})
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<ClientView>> findAll() {
        LOGGER.info("Called findAll clients");
        return restResponses.ok(clientService.findAll());
    }

}
