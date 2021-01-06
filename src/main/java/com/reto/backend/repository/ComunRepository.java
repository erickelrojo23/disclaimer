package com.reto.backend.repository;

import com.reto.backend.model.entity.Comun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunRepository extends JpaRepository<Comun, Long> {
}
