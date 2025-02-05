package com.classproject.FitnessCenter.Service;

import com.classproject.FitnessCenter.entity.CheckTraining;
import com.classproject.FitnessCenter.entity.DoneTraining;
import com.classproject.FitnessCenter.entity.RateTraining;
import com.classproject.FitnessCenter.entity.Training;
import com.classproject.FitnessCenter.entity.dto.RateTrainingDTO;

import java.util.List;
import java.util.Optional;

public interface TrainingService {

    List<Training> findAll();
    Training findOne(Long id);
    Training findOneById(Long trainingId);
    List<DoneTraining> findSve();
    List<CheckTraining> findAllCheck();
    void deleteRate(Long id);

    CheckTraining create(CheckTraining checkTraining);

    void deleteCheck(Long id);

    List<RateTraining> findAllRate();

    RateTraining findRateOne(Long id);

    RateTraining createRate(RateTrainingDTO rateTrainingDTO);

    DoneTraining findOneDone(Long id);
}

