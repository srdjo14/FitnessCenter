package com.classproject.FitnessCenter.repository;

import com.classproject.FitnessCenter.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findAllByName(String name);

    List<Training> findByLength(String length);

    List<Training> findByNameIgnoreCase(String name);

}

