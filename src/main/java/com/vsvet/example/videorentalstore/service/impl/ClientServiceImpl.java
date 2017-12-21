package com.vsvet.example.videorentalstore.service.impl;

import com.vsvet.example.videorentalstore.repository.ClientRepository;
import com.vsvet.example.videorentalstore.service.ClientService;
import com.vsvet.example.videorentalstore.view.ClientView;
import com.vsvet.example.videorentalstore.view.converter.ClientConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = Objects.requireNonNull(clientRepository);
    }


    @Override
    public List<ClientView> findAll() {
        ClientConverter converter = new ClientConverter();
        return clientRepository.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClientView> findByEmail(String email) {
        ClientConverter converter = new ClientConverter();
        return clientRepository.findByEmail(email)
                .map(converter::convert);
    }
}
