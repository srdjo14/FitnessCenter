package com.classproject.FitnessCenter.Service;

import com.classproject.FitnessCenter.controller.TrainingController;
import com.classproject.FitnessCenter.entity.CheckTraining;
import com.classproject.FitnessCenter.entity.DoneTraining;
import com.classproject.FitnessCenter.entity.Training;
import com.classproject.FitnessCenter.entity.dto.DoneTrainingDTO;
import com.classproject.FitnessCenter.entity.dto.TrainingDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TrainingService {

    List<Training> findAll();
    Training findOne(Long id);
    Training findOneById(Long trainingId);
    List<DoneTraining> findSve();
    List<CheckTraining> findAllCheck();
    void delete(Long id);

}

