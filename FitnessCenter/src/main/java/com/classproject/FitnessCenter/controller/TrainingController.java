package com.classproject.FitnessCenter.controller;


import com.classproject.FitnessCenter.Service.TrainingService;
import com.classproject.FitnessCenter.entity.Terms;
import com.classproject.FitnessCenter.entity.Training;
import com.classproject.FitnessCenter.entity.dto.TermsDTO;
import com.classproject.FitnessCenter.entity.dto.TrainingDTO;
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

    /* Dobavaljanje svih treninga koji su u ponudi
    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrainingDTO>> getTraining() {
        // Pozivanjem metode servisa dobavljamo sve treninge
        List<Training> trainingList = this.trainingService.findAll();

        List<TrainingDTO> trainingDTOS = new ArrayList<>();

        for (Training training : trainingList) {
            TrainingDTO trainingDTO = new TrainingDTO(training.getId(), training.getName(), training.getAboutTraining(),
                    training.getTypeOfTraining(), training.getLength());
            trainingDTOS.add(trainingDTO);
        }

        // Vraćamo odgovor 200 OK, a kroz body odgovora šaljemo podatke o pronađenim zaposlenima
        return new ResponseEntity<>(trainingDTOS, HttpStatus.OK);
    }*/
   /* @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainingDTO> createTer(@RequestBody TrainingDTO trainingDTO) throws Exception {
        Training training = trainingService.addTerms(trainingDTO);
        trainingDTO.setId(training.getId());
        return new ResponseEntity<>(trainingDTO, HttpStatus.CREATED);
    }*/

    /* Dobavljanje svih odradjenih treninga */
    @GetMapping(value = "/done", produces = )
}
