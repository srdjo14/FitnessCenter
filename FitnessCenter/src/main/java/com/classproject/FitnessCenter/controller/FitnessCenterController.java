package com.classproject.FitnessCenter.controller;


import com.classproject.FitnessCenter.Service.FitnessCenterService;
import com.classproject.FitnessCenter.Service.HallService;
import com.classproject.FitnessCenter.entity.FitnessCenter;
import com.classproject.FitnessCenter.entity.Hall;
import com.classproject.FitnessCenter.entity.Training;
import com.classproject.FitnessCenter.entity.dto.FitnessCenterDTO;
import com.classproject.FitnessCenter.entity.dto.HallDTO;
import com.classproject.FitnessCenter.entity.dto.TrainingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/fit-center")
public class FitnessCenterController {

    private FitnessCenterService fitnessCenterService;
    private HallService hallService;
    @Autowired
    public FitnessCenterController(FitnessCenterService fitnessCenterService, HallService hallService) {
        this.fitnessCenterService = fitnessCenterService;
        this.hallService = hallService;
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
    @PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCenterDTO> createFitnessCenter(@RequestBody FitnessCenterDTO fitnessCenterDTO) throws Exception {
        FitnessCenter fitnessCenter = new FitnessCenter(fitnessCenterDTO.getNaziv(), fitnessCenterDTO.getAddress(),
                fitnessCenterDTO.getContactPhone(), fitnessCenterDTO.getEmail());

        FitnessCenter newFitnessCenter = fitnessCenterService.create(fitnessCenter);

        FitnessCenterDTO newFitnessCenterDTO = new FitnessCenterDTO(newFitnessCenter.getId(), newFitnessCenter.getNaziv(),
                newFitnessCenter.getAddress(), newFitnessCenter.getContactPhone(), newFitnessCenter.getEmail());

        return new ResponseEntity<>(newFitnessCenterDTO, HttpStatus.CREATED);
    }

    /* Prikaz svih sala */
    @GetMapping(value = "/hall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnessCenterDTO>> getHall(){

        List<FitnessCenter> fitnessCenterList = this.fitnessCenterService.findAll();
        List<FitnessCenterDTO> fitnessCenterDTOS = new ArrayList<>();

        for(FitnessCenter fitnessCenter : fitnessCenterList){
            FitnessCenterDTO fitnessCenterDTO = new FitnessCenterDTO();
            fitnessCenterDTO.setId(fitnessCenter.getId());
            fitnessCenterDTO.setNaziv(fitnessCenter.getNaziv());
            fitnessCenterDTO.setAddress(fitnessCenter.getAddress());
            fitnessCenterDTO.setContactPhone(fitnessCenter.getContactPhone());
            fitnessCenterDTO.setEmail(fitnessCenter.getEmail());
            List<HallDTO> hallDTOList = new ArrayList<>();
            for (Hall hall : fitnessCenter.getHall()){
                HallDTO hallDTO = new HallDTO();
                hallDTO.setId(hall.getId());
                hallDTO.setCapacity(hall.getCapacity());
                hallDTO.setNumberOfHall(hall.getNumberOfHall());
                hallDTOList.add(hallDTO);
            }
            fitnessCenterDTO.setHallList(hallDTOList);
            fitnessCenterDTOS.add(fitnessCenterDTO);
        }
        return new ResponseEntity<>(fitnessCenterDTOS, HttpStatus.OK);
    }

    /* Izmjena postojeceg fitnes centra */
    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCenterDTO> updateFitnessCenter(@PathVariable Long id, @Validated @RequestBody FitnessCenterDTO fitnessCenterDTO) throws Exception {
        Optional<FitnessCenter> f2 = fitnessCenterService.findOne(id);
        if(!f2.isPresent()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        FitnessCenter fitnessCenter = new FitnessCenter(f2.get().getId(), fitnessCenterDTO.getNaziv(), fitnessCenterDTO.getAddress(), fitnessCenterDTO.getEmail(),
                fitnessCenterDTO.getContactPhone());

        fitnessCenter = fitnessCenterService.update(fitnessCenter);

        fitnessCenterDTO.setId(id);
        return new ResponseEntity<>(fitnessCenterDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteFC(@PathVariable Long id){
        fitnessCenterService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
