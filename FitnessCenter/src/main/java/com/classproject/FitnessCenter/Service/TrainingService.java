package com.classproject.FitnessCenter.Service;

import com.classproject.FitnessCenter.controller.TrainingController;
import com.classproject.FitnessCenter.entity.Training;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TrainingService {

    List<Training> findAll();
    Training findOne(Long id);
}
