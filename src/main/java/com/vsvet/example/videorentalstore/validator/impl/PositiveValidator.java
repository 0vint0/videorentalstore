package com.vsvet.example.videorentalstore.validator.impl;

import com.vsvet.example.videorentalstore.validator.AbstractConstraintValidator;
import com.vsvet.example.videorentalstore.validator.NotNull;
import com.vsvet.example.videorentalstore.validator.Positive;

import java.text.MessageFormat;

public class PositiveValidator extends AbstractConstraintValidator<Positive, Integer> {

    private Positive positive;

    @Override
    public void initialize(Positive positive) {
        this.positive = positive;
    }

    @Override
    protected boolean isValid(Integer value) {
        return value == null|| value>0;
    }

    @Override
    protected String getValidationMessage(Integer value) {
        return MessageFormat.format(positive.message(),positive.fieldName());
    }


}
