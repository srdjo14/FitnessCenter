package com.classproject.FitnessCenter.Service;

import com.classproject.FitnessCenter.entity.Trainer;


import java.util.List;

public interface TrainerService {

    List<Trainer> findAll();
    Trainer update(Trainer trainer) throws Exception;
    Trainer create(Trainer trainer) throws Exception;
    List<Trainer> getUnactive();

    void delete(Long id);



}
