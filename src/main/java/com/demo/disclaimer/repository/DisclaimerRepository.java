package com.demo.disclaimer.repository;

import com.demo.disclaimer.model.entity.DisclaimerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisclaimerRepository extends JpaRepository<DisclaimerEntity, Long> {

    @Query(
            value = "SELECT * FROM disclaimer u WHERE u.text like %?1%",
            nativeQuery = true)
    List<DisclaimerEntity> findByText(String text);
}
