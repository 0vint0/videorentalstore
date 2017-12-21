package com.vsvet.example.videorentalstore.service.impl;

import com.vsvet.example.videorentalstore.repository.ClientRepository;
import com.vsvet.example.videorentalstore.repository.MovieRentalRepository;
import com.vsvet.example.videorentalstore.repository.MovieRepository;
import com.vsvet.example.videorentalstore.service.MovieRentalService;
import com.vsvet.example.videorentalstore.service.PriceCalculationService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieRentalServiceTestConfig {

    @Bean
    public MovieRentalService movieRentalService() {
        return new MovieRentalServiceImpl(
                        movieRepository(),
                        priceCalculationService(),
                        movieRentalRepository(),
                        clientRepository()
                        );
    }

    @Bean
    public MovieRepository movieRepository() {
        return Mockito.mock(MovieRepository.class);
    }

    @Bean
    public MovieRentalRepository movieRentalRepository() {
        return Mockito.mock(MovieRentalRepository.class);
    }

    @Bean
    public ClientRepository clientRepository() {
        return Mockito.mock(ClientRepository.class);
    }

    @Bean
    public PriceCalculationService priceCalculationService() {
        return Mockito.mock(PriceCalculationService.class);
    }
}
