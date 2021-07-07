package com.classproject.FitnessCenter.repository;

import com.classproject.FitnessCenter.entity.CheckTraining;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckTrainingRepository extends JpaRepository<CheckTraining, Long> {
    List<CheckTraining> findAll();
}
