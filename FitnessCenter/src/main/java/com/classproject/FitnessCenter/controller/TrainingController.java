package com.classproject.FitnessCenter.controller;


import com.classproject.FitnessCenter.Service.TrainingService;
import com.classproject.FitnessCenter.entity.Training;
import com.classproject.FitnessCenter.entity.dto.TrainingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /* Dobavaljanje svih treninga koji su u ponudi */
    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrainingDTO>> getTraining() {
        // Pozivanjem metode servisa dobavljamo sve treninge
        List<Training> trainingList = this.trainingService.findAll();

        List<TrainingDTO> trainingDTOS = new ArrayList<>();

        for (Training training : trainingList) {
            TrainingDTO trainingDTO = new TrainingDTO(training.getId(), training.getName(), training.getAboutTraining(),
                    training.getTypeOfTraining(), training.getLength(), training.getFitnessTrainer());
            trainingDTOS.add(trainingDTO);
        }

        // Vraćamo odgovor 200 OK, a kroz body odgovora šaljemo podatke o pronađenim zaposlenima
        return new ResponseEntity<>(trainingDTOS, HttpStatus.OK);
    }
}
