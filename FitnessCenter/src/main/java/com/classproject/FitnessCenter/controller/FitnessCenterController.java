package com.classproject.FitnessCenter.controller;


import com.classproject.FitnessCenter.Service.FitnessCenterService;
import com.classproject.FitnessCenter.entity.FitnessCenter;
import com.classproject.FitnessCenter.entity.Training;
import com.classproject.FitnessCenter.entity.dto.FitnessCenterDTO;
import com.classproject.FitnessCenter.entity.dto.TrainingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/fit-center")
public class FitnessCenterController {

    private FitnessCenterService fitnessCenterService;
    @Autowired
    public FitnessCenterController(FitnessCenterService fitnessCenterService) {
        this.fitnessCenterService = fitnessCenterService;
    }

    /* Prikaz svih fitnes centara */
    @GetMapping(value="/fit", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnessCenterDTO>> getFit() {


        // Pozivanjem metode servisa dobavljamo sve treninge
        List<FitnessCenter> fitnessCenterList = this.fitnessCenterService.findAll();

        List<FitnessCenterDTO> fitnessCenterDTOS = new ArrayList<>();

        for (FitnessCenter fitnessCenter : fitnessCenterList) {
            FitnessCenterDTO fitnessCenterDTO = new FitnessCenterDTO(fitnessCenter.getId(), fitnessCenter.getNaziv(), fitnessCenter.getAddress(),
                    fitnessCenter.getContactPhone(), fitnessCenter.getEmail());
            fitnessCenterDTOS.add(fitnessCenterDTO);
        }

        // Vraćamo odgovor 200 OK, a kroz body odgovora šaljemo podatke o pronađenim zaposlenima
        return new ResponseEntity<>(fitnessCenterDTOS, HttpStatus.OK);

    }

    /* Dodavanje novog fitnes centra */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCenterDTO> createFitnessCenter(@RequestBody FitnessCenterDTO fitnessCenterDTO) throws Exception {
        FitnessCenter fitnessCenter = new FitnessCenter(fitnessCenterDTO.getNaziv(), fitnessCenterDTO.getAddress(),
                fitnessCenterDTO.getContactPhone(), fitnessCenterDTO.getEmail());

        FitnessCenter newFitnessCenter = fitnessCenterService.create(fitnessCenter);

        FitnessCenterDTO newFitnessCenterDTO = new FitnessCenterDTO(newFitnessCenter.getId(), newFitnessCenter.getNaziv(),
                newFitnessCenter.getAddress(), newFitnessCenter.getContactPhone(), newFitnessCenter.getEmail());

        return new ResponseEntity<>(newFitnessCenterDTO, HttpStatus.CREATED);
    }

    /* Izmjena postojeceg fitnes centra */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCenterDTO> updateFitnessCenter(@PathVariable Long id, @RequestBody FitnessCenterDTO fitnessCenterDTO) throws Exception {
        FitnessCenter fitnessCenter = new FitnessCenter(fitnessCenterDTO.getNaziv(), fitnessCenterDTO.getAddress(), fitnessCenterDTO.getEmail(),
                fitnessCenterDTO.getContactPhone());

        fitnessCenter.setId(id);

        FitnessCenter updatedFc = fitnessCenterService.update(fitnessCenter);

        FitnessCenterDTO updatedFcDTO = new FitnessCenterDTO(updatedFc.getId(), updatedFc.getNaziv(), updatedFc.getEmail(), updatedFc.getAddress(), updatedFc.getContactPhone());

        return new ResponseEntity<>(updatedFcDTO, HttpStatus.OK);
    }

    /* Brisanje fitnes centra */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFitnessCenter(@PathVariable Long id){
        // Brisemo fitnes centar po ID-ju
        this.fitnessCenterService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
