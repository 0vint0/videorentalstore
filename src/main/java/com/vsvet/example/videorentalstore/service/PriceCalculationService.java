package com.vsvet.example.videorentalstore.service;

import com.vsvet.example.videorentalstore.domain.Movie;
import com.vsvet.example.videorentalstore.validator.MovieIdsExist;
import com.vsvet.example.videorentalstore.validator.NotNull;
import com.vsvet.example.videorentalstore.validator.Positive;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.List;

@Validated
public interface PriceCalculationService {

    BigDecimal calculate(@NotNull @MovieIdsExist List<Movie> movies,
                         @Positive(fieldName = "period") @NotNull(fieldName = "period") Integer period);
}
