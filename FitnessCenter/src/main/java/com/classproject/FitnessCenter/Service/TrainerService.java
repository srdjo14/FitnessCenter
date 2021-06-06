package com.classproject.FitnessCenter.Service;

import com.classproject.FitnessCenter.entity.Trainer;
import com.classproject.FitnessCenter.entity.Training;

import java.util.List;

public interface TrainerService {

    List<Trainer> findAll();
    Trainer create(Trainer trainer) throws Exception;
}
