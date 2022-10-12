package com.example.demo.patiens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatiensRepository
        extends JpaRepository<Patiens, Long> {

    @Query("Select s FROM Patiens s Where  s.cedula = ?1")
    Optional<Patiens> findPatiensByCedula(Long cedula);
}
