package com.vsvet.example.videorentalstore.repository;

import com.vsvet.example.videorentalstore.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Lock(LockModeType.OPTIMISTIC)
    List<Movie> findAllByIdIn(List<Long> ids);
}
