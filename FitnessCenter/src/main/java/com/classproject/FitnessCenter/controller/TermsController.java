package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.Service.TermsService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/terms")
public class TermsController {

    private final TermsService termsService;
    @Autowired
    public TermsController(TermsService termsService) {
        this.termsService = termsService;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TermsDTO> createHall(@RequestBody TermsDTO termsDTO) throws Exception {
        Terms terms = termsService.addTerms(termsDTO);
        termsDTO.setId(terms.getId());
        return new ResponseEntity<>(termsDTO, HttpStatus.CREATED);
    }
}
