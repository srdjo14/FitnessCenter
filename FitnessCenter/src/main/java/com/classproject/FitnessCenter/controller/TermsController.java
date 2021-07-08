package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.Service.TermsService;
import com.classproject.FitnessCenter.Service.TrainingService;
import com.classproject.FitnessCenter.entity.FitnessCenter;
import com.classproject.FitnessCenter.entity.Hall;
import com.classproject.FitnessCenter.entity.Terms;
import com.classproject.FitnessCenter.entity.Training;
import com.classproject.FitnessCenter.entity.dto.FitnessCenterDTO;
import com.classproject.FitnessCenter.entity.dto.HallDTO;
import com.classproject.FitnessCenter.entity.dto.TermsDTO;
import com.classproject.FitnessCenter.entity.dto.TrainingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TermsDTO> createHall(@RequestBody TermsDTO termsDTO) throws Exception {
        Terms terms = termsService.addTerms(termsDTO);
        termsDTO.setId(terms.getId());
        return new ResponseEntity<>(termsDTO, HttpStatus.CREATED);
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
