package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.TrainerService;
import com.classproject.FitnessCenter.entity.Member;
import com.classproject.FitnessCenter.entity.Trainer;
import com.classproject.FitnessCenter.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService {

    TrainerRepository trainerRepository;
    @Autowired
    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }


    @Override
    public Trainer create(Trainer trainer) throws Exception {
        if (trainer.getId() != null) {
            throw new Exception("ID must be null!");
        }

        Trainer newTrainer = this.trainerRepository.save(trainer);
        return newTrainer;
    }
}
