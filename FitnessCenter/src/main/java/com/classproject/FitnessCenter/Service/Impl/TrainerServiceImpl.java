package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.TrainerService;
import com.classproject.FitnessCenter.entity.Trainer;
import com.classproject.FitnessCenter.entity.Training;
import com.classproject.FitnessCenter.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository trainerRepository;
    @Autowired
    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }


    @Override
    public List<Trainer> findAll() {
        List<Trainer> trainer = this.trainerRepository.findAll();
        return trainer;
    }

    @Override
    public Trainer update(Trainer trainer) throws Exception {
        Trainer trainerToUpdate = this.trainerRepository.getOne(trainer.getId());
        if(trainerToUpdate == null){
            throw new Exception("Trener ne postoji!");
        }

        trainerToUpdate.setActive(trainer.getActive());

        Trainer savedEm = this.trainerRepository.save(trainerToUpdate);
        return savedEm;
    }

    @Override
    public Trainer create(Trainer trainer) throws Exception {
        if (trainer.getId() != null) {
            throw new Exception("ID must be null!");
        }

        Trainer newTrainer = this.trainerRepository.save(trainer);
        return newTrainer;
    }

    @Override
    public List<Trainer> getUnactive() {
        return trainerRepository.getAllByActive(false);
    }

    @Override
    public void delete(Long id) {
        this.trainerRepository.deleteById(id);
    }

}
