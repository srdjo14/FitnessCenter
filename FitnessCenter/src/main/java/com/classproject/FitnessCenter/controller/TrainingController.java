package com.classproject.FitnessCenter.controller;


import com.classproject.FitnessCenter.Service.MemberService;
import com.classproject.FitnessCenter.Service.TermsService;
import com.classproject.FitnessCenter.Service.TrainingService;
import com.classproject.FitnessCenter.Service.UserService;
import com.classproject.FitnessCenter.entity.*;
import com.classproject.FitnessCenter.entity.dto.*;
import com.classproject.FitnessCenter.repository.DoneTrainingRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/training")
public class TrainingController {

    private final TrainingService trainingService;
    private final MemberService memberService;
    private final TermsService termsService;

    @Autowired
    public TrainingController(TrainingService trainingService, MemberService memberService, TermsService termsService) {
        this.trainingService = trainingService;
        this.memberService = memberService;
        this.termsService = termsService;
    }

    /* Dobavljanje svih odradjenih treninga */
    @GetMapping(value = "/done", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DoneTrainingDTO>> getDone() {
        List<DoneTraining> doneTrainings = this.trainingService.findSve();
        List<DoneTrainingDTO> doneTrainingDTOS = new ArrayList<>();

        for (DoneTraining doneTraining : doneTrainings) {
            DoneTrainingDTO doneTrainingDTO = new DoneTrainingDTO(
                    doneTraining.getId(),
                    doneTraining.getMembers().getUsername(),
                    doneTraining.getTerms().getTraining().getName(),
                    doneTraining.getTerms().getTraining().getAboutTraining(),
                    doneTraining.getTerms().getTraining().getTypeOfTraining(),
                    doneTraining.getTerms().getTraining().getLength(),
                    doneTraining.getTerms().getPrice(),
                    doneTraining.getTerms().getTrainingDay()
            );
            doneTrainingDTOS.add(doneTrainingDTO);
        }
        return new ResponseEntity<>(doneTrainingDTOS, HttpStatus.OK);
    }

    /* Dobavljanje ocijenjenjih treninga */
    @GetMapping(value = "/rate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RateTrainingDTO>> getRate(){
        List<RateTraining> rateTrainings = this.trainingService.findAllRate();
        List<RateTrainingDTO> rateTrainingDTOS = new ArrayList<>();

        for (RateTraining rateTraining : rateTrainings){
            RateTrainingDTO rateTrainingDTO = new RateTrainingDTO(
                    rateTraining.getId(),
                    rateTraining.getMembers().getUsername(),
                    rateTraining.getTerms().getTraining().getName(),
                    rateTraining.getTerms().getTraining().getAboutTraining(),
                    rateTraining.getTerms().getTraining().getTypeOfTraining(),
                    rateTraining.getGrade()
            );
            rateTrainingDTOS.add(rateTrainingDTO);
        }
        return new ResponseEntity<>(rateTrainingDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CheckTrainingDTO>> getCheck() {
        List<CheckTraining> checkTrainings = this.trainingService.findAllCheck();
        List<CheckTrainingDTO> checkTrainingDTOS = new ArrayList<>();

        for (CheckTraining checkTraining : checkTrainings) {
            CheckTrainingDTO checkTrainingDTO = new CheckTrainingDTO(
                    checkTraining.getId(),
                    checkTraining.getMembers().getUsername(),
                    checkTraining.getTerms().getTraining().getName(),
                    checkTraining.getTerms().getTraining().getAboutTraining(),
                    checkTraining.getTerms().getTraining().getTypeOfTraining(),
                    checkTraining.getTerms().getTraining().getLength(),
                    checkTraining.getTerms().getPrice(),
                    checkTraining.getTerms().getTrainingDay()
            );
            checkTrainingDTOS.add(checkTrainingDTO);
        }
        return new ResponseEntity<>(checkTrainingDTOS, HttpStatus.OK);
    }

    @JsonIgnore
    @PostMapping(value = "/addCheck/{memberId}/{termsId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CheckTrainingDTO> createCheck(@PathVariable Long memberId, @PathVariable Long termsId, @RequestBody CheckTrainingDTO checkTrainingDTO) throws Exception {
        Member member = this.memberService.findOneById(memberId);
        Terms terms = this.termsService.findOneById(termsId);
        if (member == null || terms == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        CheckTraining checkTraining = new CheckTraining(member, terms);
        CheckTraining newCheckTraining = trainingService.create(checkTraining);

        CheckTrainingDTO checkTrainingDTO1 = new CheckTrainingDTO(newCheckTraining.getId(), newCheckTraining.getMembers(), newCheckTraining.getTerms());

        return new ResponseEntity<>(checkTrainingDTO1, HttpStatus.CREATED);
    }

    @PostMapping(value = "/addRate/{grade}/{memberId}/{termsId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RateTrainingDTO> createRate(@PathVariable Integer grade, @PathVariable Long memberId, @PathVariable Long termsId, @RequestBody RateTrainingDTO rateTrainingDTO) throws Exception {
        Member member = this.memberService.findOneById(memberId);
        Terms terms = this.termsService.findOneById(termsId);
        if (member == null || terms == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        RateTraining rateTraining = new RateTraining(grade, member, terms);
        RateTraining newRateTraining = trainingService.createRate(rateTraining);

        RateTrainingDTO rateTrainingDTO1 = new RateTrainingDTO(newRateTraining.getId(), newRateTraining.getGrade(), newRateTraining.getMembers(), newRateTraining.getTerms());

        return new ResponseEntity<>(rateTrainingDTO1, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteFC(@PathVariable Long id) {
        trainingService.deleteCheck(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

