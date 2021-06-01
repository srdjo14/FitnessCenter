package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.Service.FitnessCenterService;
import com.classproject.FitnessCenter.entity.FitnessCenter;
import com.classproject.FitnessCenter.entity.dto.FitnessCenterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/fit-center")
public class FitnessCenterController {

    FitnessCenterService fitnessCenterService;

    @Autowired

    public FitnessCenterController(FitnessCenterService fitnessCenterService) {
        this.fitnessCenterService = fitnessCenterService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCenterDTO> createFitnessCenter(@RequestBody FitnessCenterDTO fitnessCenterDTO) throws Exception {
        FitnessCenter fitnessCenter = new FitnessCenter(fitnessCenterDTO.getNaziv(), fitnessCenterDTO.getAddress(), fitnessCenterDTO.getEmail(),
                fitnessCenterDTO.getContactPhone());

        FitnessCenter newFitnessCenter = fitnessCenterService.create(fitnessCenter);

        FitnessCenterDTO newFitnessCenterDTO = new FitnessCenterDTO(newFitnessCenter.getId(), newFitnessCenter.getNaziv(), newFitnessCenter.getEmail(),
                newFitnessCenter.getAddress(), newFitnessCenter.getContactPhone());

        return new ResponseEntity<>(newFitnessCenterDTO, HttpStatus.CREATED);
    }

}
