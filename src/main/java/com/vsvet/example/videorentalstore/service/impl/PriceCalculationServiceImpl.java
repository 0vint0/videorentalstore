package com.vsvet.example.videorentalstore.service.impl;

import com.vsvet.example.videorentalstore.domain.Movie;
import com.vsvet.example.videorentalstore.domain.MoviePrice;
import com.vsvet.example.videorentalstore.service.PriceCalculationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PriceCalculationServiceImpl implements PriceCalculationService {

    @Override
    public BigDecimal calculate(List<Movie> movies, Integer period) {
        return movies.stream()
                .map(m -> getPrice(m.getMoviePrice(), period))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getPrice(MoviePrice moviePrice, Integer period) {
        Integer additionalPeriod = getAdditionalPeriod(moviePrice, period);
        return moviePrice.getPrice().add(moviePrice.getPrice().multiply(BigDecimal.valueOf(additionalPeriod)));
    }

    private Integer getAdditionalPeriod(MoviePrice moviePrice, Integer period) {
        if (period < moviePrice.getStartPeriod()) {
            return 0;
        } else {
            return period - moviePrice.getStartPeriod();
        }
    }
}
