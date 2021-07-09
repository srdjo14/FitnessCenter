package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.MemberService;
import com.classproject.FitnessCenter.Service.TermsService;
import com.classproject.FitnessCenter.Service.TrainingService;

import com.classproject.FitnessCenter.entity.*;
import com.classproject.FitnessCenter.entity.dto.RateTrainingDTO;
import com.classproject.FitnessCenter.repository.CheckTrainingRepository;
import com.classproject.FitnessCenter.repository.DoneTrainingRepository;
import com.classproject.FitnessCenter.repository.RateTrainingRepository;
import com.classproject.FitnessCenter.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;
    private final DoneTrainingRepository doneTrainingRepository;
    private final CheckTrainingRepository checkTrainingRepository;
    private final RateTrainingRepository rateTrainingRepository;
    private final MemberService memberService;
    private final TermsService termsService;

    @Autowired
    public TrainingServiceImpl(TrainingRepository trainingRepository, DoneTrainingRepository doneTrainingRepository, CheckTrainingRepository checkTrainingRepository, RateTrainingRepository rateTrainingRepository, MemberService memberService, TermsService termsService) {
        this.trainingRepository = trainingRepository;
        this.doneTrainingRepository = doneTrainingRepository;
        this.checkTrainingRepository = checkTrainingRepository;
        this.rateTrainingRepository = rateTrainingRepository;
        this.memberService = memberService;
        this.termsService = termsService;
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
    public void deleteRate(Long id) {
        this.rateTrainingRepository.deleteById(id);
    }

    @Override
    public CheckTraining create(CheckTraining checkTraining) {
        return this.checkTrainingRepository.save(checkTraining);
    }

    @Override
    public void deleteCheck(Long id) {
        this.checkTrainingRepository.deleteById(id);
    }

    @Override
    public List<RateTraining> findAllRate() {
        return this.rateTrainingRepository.findAll();
    }

    @Override
    public RateTraining findRateOne(Long id) {
        return this.rateTrainingRepository.findOneById(id);
    }

    @Override
    public RateTraining createRate(RateTrainingDTO rateTrainingDTO) {
       RateTraining rateTraining = new RateTraining();
       rateTraining.setGrade(rateTrainingDTO.getGrade());

       Member member = memberService.findOneById(rateTrainingDTO.getMember());
       Terms terms = termsService.findOneById(rateTrainingDTO.getTerms());

       rateTraining.setMembers(member);
       rateTraining.setTerms(terms);
       rateTrainingRepository.save(rateTraining);
       return rateTraining;
    }

    @Override
    public DoneTraining findOneDone(Long id) {
        return this.doneTrainingRepository.findOneById(id);
    }

}
