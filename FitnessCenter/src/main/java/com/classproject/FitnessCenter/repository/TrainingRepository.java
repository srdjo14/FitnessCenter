package com.classproject.FitnessCenter.repository;

import com.classproject.FitnessCenter.entity.FitnessCenter;
import com.classproject.FitnessCenter.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findAllByNameContaining(String name);

    List<Training> findByName(String name);

    List<Training> findAllByAboutTrainingContaining(String about);

    List<Training> findAllByTypeOfTrainingContaining(String typeOfTraining);

    Training findOneById(Long id);
}

