package com.classproject.FitnessCenter.controller;


import com.classproject.FitnessCenter.Service.MemberService;
import com.classproject.FitnessCenter.Service.TermsService;
import com.classproject.FitnessCenter.Service.TrainingService;
import com.classproject.FitnessCenter.Service.UserService;
import com.classproject.FitnessCenter.entity.*;
import com.classproject.FitnessCenter.entity.dto.CheckTrainingDTO;
import com.classproject.FitnessCenter.entity.dto.DoneTrainingDTO;
import com.classproject.FitnessCenter.entity.dto.TermsDTO;
import com.classproject.FitnessCenter.entity.dto.TrainingDTO;
import com.classproject.FitnessCenter.repository.DoneTrainingRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    /*    @PostMapping(value = "/prijava/{memberId}/{termsId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CheckTrainingDTO> prijaviTermin(@PathVariable Long memberId, @PathVariable Long termsId, @RequestBody CheckTrainingDTO checkTrainingDTO){

        Member member = this.memberService.findOneById(memberId);
        Terms terms = this.termsService.findOneById(termsId);

        if(member == null || terms == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        CheckTraining checkTraining = new CheckTraining(checkTrainingDTO.getMemberId(), checkTrainingDTO.getTermId());
        CheckTraining newCheck = trainingService.create(checkTraining);

        CheckTrainingDTO newCheckTrainingDTO = new CheckTrainingDTO(member, terms);

        return new ResponseEntity<>(newCheckTrainingDTO, HttpStatus.CREATED);
    */

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteFC(@PathVariable Long id) {
        trainingService.deleteCheck(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

