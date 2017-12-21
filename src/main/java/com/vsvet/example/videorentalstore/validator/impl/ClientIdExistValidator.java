package com.vsvet.example.videorentalstore.validator.impl;

import com.vsvet.example.videorentalstore.repository.ClientRepository;
import com.vsvet.example.videorentalstore.validator.AbstractConstraintValidator;
import com.vsvet.example.videorentalstore.validator.ClientIdExist;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;

public class ClientIdExistValidator extends AbstractConstraintValidator<ClientIdExist, Long> {

    private ClientIdExist clientIdExist;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void initialize(ClientIdExist clientIdExist) {
        this.clientIdExist = clientIdExist;
    }

    @Override
    protected boolean isValid(Long value) {
        return clientRepository.findOne(value) != null;
    }

    @Override
    protected String getValidationMessage(Long value) {
        return MessageFormat.format(clientIdExist.message(), value);
    }


}
