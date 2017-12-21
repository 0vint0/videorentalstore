package com.vsvet.example.videorentalstore.validator.impl;

import com.vsvet.example.videorentalstore.validator.AbstractConstraintValidator;
import com.vsvet.example.videorentalstore.validator.NotNullOrBlank;

import java.text.MessageFormat;

public class NotNullOrBlankValidator extends AbstractConstraintValidator<NotNullOrBlank, String> {


    private NotNullOrBlank notBlank;

    @Override
    public void initialize(NotNullOrBlank notBlank) {
        this.notBlank = notBlank;
    }


    @Override
    protected boolean isValid(String value) {
        return value != null && !value.isEmpty();
    }

    @Override
    protected String getValidationMessage(String value) {
        return MessageFormat.format(notBlank.message(), notBlank.fieldName());
    }


}
