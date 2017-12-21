package com.vsvet.example.videorentalstore.repository;

import com.vsvet.example.videorentalstore.domain.MovieRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRentalRepository extends JpaRepository<MovieRental,Long> {
}
