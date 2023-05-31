package com.demo.disclaimer.repository;

import com.demo.disclaimer.model.entity.AcceptanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcceptanceRepository extends JpaRepository<AcceptanceEntity, Long> {

    List<AcceptanceEntity> findByUserId(Long userId);
}
