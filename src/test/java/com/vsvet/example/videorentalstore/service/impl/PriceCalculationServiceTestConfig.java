package com.vsvet.example.videorentalstore.service.impl;

import com.vsvet.example.videorentalstore.repository.MovieRepository;
import com.vsvet.example.videorentalstore.service.PriceCalculationService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PriceCalculationServiceTestConfig {

    @Bean
    public PriceCalculationService priceCalculationService(){
        return new PriceCalculationServiceImpl();
    }

    @Bean
    public MovieRepository movieRepository(){
        return Mockito.mock(MovieRepository.class);
    }

}
