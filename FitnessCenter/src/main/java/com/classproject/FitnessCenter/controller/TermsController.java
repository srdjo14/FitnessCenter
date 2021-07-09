package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.Service.TermsService;
import com.classproject.FitnessCenter.Service.TrainingService;
import com.classproject.FitnessCenter.entity.Terms;
import com.classproject.FitnessCenter.entity.Training;
import com.classproject.FitnessCenter.entity.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/terms")
public class TermsController {

    private final TermsService termsService;
    private final TrainingService trainingService;
    @Autowired
    public TermsController(TermsService termsService, TrainingService trainingService) {
        this.termsService = termsService;
        this.trainingService = trainingService;
    }


    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
         consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TermsDTO> updateTerms(@PathVariable Long id, @RequestBody TermsDTO termsDTO) throws Exception{
        Optional<Terms> terms1 = termsService.findOne(id);

        Training training = new Training();
        training = trainingService.findOneById(termsDTO.getTrainingId());

        Terms terms = new Terms(
                terms1.get().getId(),
                termsDTO.getPrice(),
                termsDTO.getTrainingDay(),
                training
        );
        terms = termsService.updateTerms(terms);
        termsDTO.setId(id);
        return new ResponseEntity<>(termsDTO, HttpStatus.ACCEPTED);
    }
}
