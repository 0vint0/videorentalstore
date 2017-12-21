package com.vsvet.example.videorentalstore.repository;

import com.vsvet.example.videorentalstore.domain.MoviePrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviePriceRepository extends JpaRepository<MoviePrice, Long> {
}
