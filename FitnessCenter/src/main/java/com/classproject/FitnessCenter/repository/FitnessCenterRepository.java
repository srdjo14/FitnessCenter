package com.classproject.FitnessCenter.repository;

import com.classproject.FitnessCenter.entity.FitnessCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessCenterRepository extends JpaRepository<FitnessCenter, Long> {
    FitnessCenter getOne(FitnessCenter fitnessCenter);
}
