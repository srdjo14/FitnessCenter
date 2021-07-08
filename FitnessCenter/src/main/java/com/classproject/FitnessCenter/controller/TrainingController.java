package com.classproject.FitnessCenter.controller;


import com.classproject.FitnessCenter.Service.TrainingService;
import com.classproject.FitnessCenter.entity.CheckTraining;
import com.classproject.FitnessCenter.entity.DoneTraining;
import com.classproject.FitnessCenter.entity.Terms;
import com.classproject.FitnessCenter.entity.Training;
import com.classproject.FitnessCenter.entity.dto.CheckTrainingDTO;
import com.classproject.FitnessCenter.entity.dto.DoneTrainingDTO;
import com.classproject.FitnessCenter.entity.dto.TermsDTO;
import com.classproject.FitnessCenter.entity.dto.TrainingDTO;
import com.classproject.FitnessCenter.repository.DoneTrainingRepository;
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

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    /* Dobavljanje svih odradjenih treninga */
    @GetMapping(value = "/done", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DoneTrainingDTO>> getDone(){
        List<DoneTraining> doneTrainings = this.trainingService.findSve();
        List<DoneTrainingDTO> doneTrainingDTOS = new ArrayList<>();

        for(DoneTraining doneTraining : doneTrainings){
            DoneTrainingDTO doneTrainingDTO = new DoneTrainingDTO(
                    doneTraining.getId(),
                    doneTraining.getMembers().getUsername(),
                    doneTraining.getTraining().getName(),
                    doneTraining.getTraining().getTypeOfTraining()
            );
            doneTrainingDTOS.add(doneTrainingDTO);
        }
        return new ResponseEntity<>(doneTrainingDTOS, HttpStatus.OK);
    }
    
    @GetMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CheckTrainingDTO>> getCheck(){
        List<CheckTraining> checkTrainings = this.trainingService.findAllCheck();
        List<CheckTrainingDTO> checkTrainingDTOS = new ArrayList<>();

        for(CheckTraining checkTraining : checkTrainings){
            CheckTrainingDTO checkTrainingDTO = new CheckTrainingDTO(
                    checkTraining.getId(),
                    checkTraining.getMembers().getUsername(),
                    checkTraining.getTraining().getName(),
                    checkTraining.getTraining().getTypeOfTraining()
            );
            checkTrainingDTOS.add(checkTrainingDTO);
        }
        return new ResponseEntity<>(checkTrainingDTOS, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteFC(@PathVariable Long id){
        trainingService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
