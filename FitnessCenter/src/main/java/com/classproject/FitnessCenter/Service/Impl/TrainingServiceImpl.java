package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.MemberService;
import com.classproject.FitnessCenter.Service.TermsService;
import com.classproject.FitnessCenter.Service.TrainingService;

import com.classproject.FitnessCenter.entity.*;
import com.classproject.FitnessCenter.entity.dto.DoneTrainingDTO;
import com.classproject.FitnessCenter.entity.dto.TrainingDTO;
import com.classproject.FitnessCenter.repository.CheckTrainingRepository;
import com.classproject.FitnessCenter.repository.DoneTrainingRepository;
import com.classproject.FitnessCenter.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;
    private final DoneTrainingRepository doneTrainingRepository;
    private final CheckTrainingRepository checkTrainingRepository;
    private final MemberService memberService;

    @Autowired
    public TrainingServiceImpl(TrainingRepository trainingRepository, DoneTrainingRepository doneTrainingRepository, CheckTrainingRepository checkTrainingRepository, MemberService memberService) {
        this.trainingRepository = trainingRepository;
        this.doneTrainingRepository = doneTrainingRepository;
        this.checkTrainingRepository = checkTrainingRepository;
        this.memberService = memberService;
    }

    /* Prikaz svih treninga */
    @Override
    public List<Training> findAll() {
        List<Training> trainings = this.trainingRepository.findAll();
        return trainings;
    }

    @Override
    public Training findOne(Long id) {
        Training training = this.trainingRepository.getOne(id);
        return training;
    }

    @Override
    public Training findOneById(Long trainingId) {
        Training training = this.trainingRepository.findOneById(trainingId);
        return null;
    }

    @Override
    public List<DoneTraining> findSve() {
        return this.doneTrainingRepository.findAll();
    }

    @Override
    public List<CheckTraining> findAllCheck() {
        return this.checkTrainingRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        this.checkTrainingRepository.deleteById(id);
    }

    @Override
    public CheckTraining create(CheckTraining checkTraining) {
        return this.checkTrainingRepository.save(checkTraining);
    }

}
