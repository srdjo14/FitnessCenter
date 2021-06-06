package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.Service.TrainerService;
import com.classproject.FitnessCenter.entity.Trainer;
import com.classproject.FitnessCenter.entity.dto.TrainerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/trainer")
public class TrainerController {
    private final TrainerService trainerService;

    /* Constructor-based dependency injection */
    @Autowired
    public TrainerController(TrainerService trainerService) {this.trainerService = trainerService; }

    /* Metoda za dobavljanje trenera iz baze */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrainerDTO>> getTrainer(){
        List<Trainer> trainerList = this.trainerService.findAll();

        List<TrainerDTO> trainerDTOList = new ArrayList<>();


        for(Trainer trainer : trainerList){

                TrainerDTO trainerDTO = new TrainerDTO(trainer.getId(), trainer.getFirstName(), trainer.getLastName(), trainer.getUsername(),
                        trainer.getContact(), trainer.getEmail(), trainer.getActive());
                trainerDTOList.add(trainerDTO);

        }
        return new ResponseEntity<>(trainerDTOList, HttpStatus.OK);
    }
    /* Metoda za registraciju novog clana fitnes centra */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainerDTO> createTrainer(@RequestBody TrainerDTO trainerDTO) throws Exception {
            Trainer trainer = new Trainer(trainerDTO.getFirstName(), trainerDTO.getLastName(), trainerDTO.getUsername(),
                    trainerDTO.getPassword(), trainerDTO.getEmail(), trainerDTO.getContact(), trainerDTO.getBirthDate(), trainerDTO.getActive(), trainerDTO.getMediumRate(),
                    trainerDTO.getFitnessCenter());

            Trainer newTrainer = trainerService.create(trainer);

            TrainerDTO newTrainerDTO = new TrainerDTO(newTrainer.getId(), newTrainer.getFirstName(), newTrainer.getLastName(),
                    newTrainer.getEmail(), newTrainer.getUsername(), newTrainer.getPassword(), newTrainer.getContact(),
                    newTrainer.getBirthDate(), newTrainer.getActive(), newTrainer.getMediumRate(), newTrainer.getFitnessCenter());

            return new ResponseEntity<>(newTrainerDTO, HttpStatus.CREATED);
    }
}
