package com.vsvet.example.videorentalstore.validator.impl;

import com.vsvet.example.videorentalstore.domain.Client;
import com.vsvet.example.videorentalstore.repository.ClientRepository;
import com.vsvet.example.videorentalstore.repository.MovieRepository;
import com.vsvet.example.videorentalstore.service.PriceCalculationService;
import com.vsvet.example.videorentalstore.validator.AbstractConstraintValidator;
import com.vsvet.example.videorentalstore.validator.ClientHasEnoughBalance;
import com.vsvet.example.videorentalstore.view.MovieRentalView;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class ClientHasEnoughBalanceValidator extends AbstractConstraintValidator<ClientHasEnoughBalance, MovieRentalView> {

    private ClientHasEnoughBalance clientHasEnoughBalance;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PriceCalculationService priceCalculationService;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void initialize(ClientHasEnoughBalance clientHasEnoughBalance) {
        this.clientHasEnoughBalance = clientHasEnoughBalance;
    }

    @Override
    protected boolean isValid(MovieRentalView value) {
        Client client = clientRepository.findOne(value.getClientId());
        if (client == null) {
            return true;
        } else {
            BigDecimal price = priceCalculationService.calculate(movieRepository.findAllByIdIn(value.getMovieIds()), value.getNumberOfDays());
            return client.getBalance().compareTo(price) >= 0;
        }
    }

    @Override
    protected String getValidationMessage(MovieRentalView value) {
        return MessageFormat.format(clientHasEnoughBalance.message(), value.getClientId());
    }


}
