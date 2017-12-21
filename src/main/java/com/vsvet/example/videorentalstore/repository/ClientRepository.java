package com.vsvet.example.videorentalstore.repository;

import com.vsvet.example.videorentalstore.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Lock(LockModeType.OPTIMISTIC)
    Optional<Client> findByEmail(String email);
}
