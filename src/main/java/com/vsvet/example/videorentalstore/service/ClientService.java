package com.vsvet.example.videorentalstore.service;

import com.vsvet.example.videorentalstore.view.ClientView;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
public interface ClientService {

    List<ClientView> findAll();

    Optional<ClientView> findByEmail(String email);
}
