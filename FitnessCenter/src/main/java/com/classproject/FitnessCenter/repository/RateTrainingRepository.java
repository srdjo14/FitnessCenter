package com.classproject.FitnessCenter.repository;

import com.classproject.FitnessCenter.entity.RateTraining;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RateTrainingRepository extends JpaRepository<RateTraining, Long> {
    Optional<RateTraining> findOneById(Long id);
}
