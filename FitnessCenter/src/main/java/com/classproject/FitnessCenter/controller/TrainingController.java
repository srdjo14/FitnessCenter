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
    public ResponseEntity<List<CheckTrainingDTO>> getCheck(){
        List<CheckTraining> checkTrainings = this.trainingService.findAllCheck();
        List<CheckTrainingDTO> checkTrainingDTOS = new ArrayList<>();

        for(CheckTraining checkTraining : checkTrainings){
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

    /*@PostMapping(value ="/addCheck", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CheckTrainingDTO> createCheck(@RequestBody CheckTrainingDTO checkTrainingDTO) throws Exception{
        CheckTraining checkTraining = new CheckTraining(checkTrainingDTO.get, checkTrainingDTO.getName(), checkTrainingDTO.getTypeOfTraining());

        CheckTraining newCheckTraining = trainingService.create(checkTraining);

        CheckTrainingDTO checkTrainingDTO1 = new CheckTrainingDTO(newCheckTraining., newCheckTraining.getTraining().getName(), newCheckTraining.getTraining().getAboutTraining(),
                );
    }*/

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteFC(@PathVariable Long id){
        trainingService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
