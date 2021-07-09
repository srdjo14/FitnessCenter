package com.classproject.FitnessCenter.repository;

import com.classproject.FitnessCenter.entity.DoneTraining;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoneTrainingRepository extends JpaRepository<DoneTraining, Long> {
    List<DoneTraining> findAll();

    DoneTraining findOneById(Long id);
}
