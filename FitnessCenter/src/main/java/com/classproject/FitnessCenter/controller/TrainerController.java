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

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrainerDTO>> getTrainerAll(){
        List<Trainer> trainerList = this.trainerService.findAll();
        List<TrainerDTO> trainerDTOList = new ArrayList<>();

        for(Trainer trainer : trainerList){
            TrainerDTO trainerDTO = new TrainerDTO(trainer.getId(), trainer.getFirstName(), trainer.getLastName());
            trainerDTOList.add(trainerDTO);
        }
        return new ResponseEntity<>(trainerDTOList, HttpStatus.OK);
    }
    /* Metoda za dobavljanje trenera iz baze koji su neaktivni jer nisu registrovani */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrainerDTO>> getTrainer(){

        List<Trainer> trainerList = this.trainerService.getUnactive();

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
                                trainerDTO.getPassword(), trainerDTO.getEmail(), trainerDTO.getContact(), trainerDTO.getBirthDate(), trainerDTO.getActive(), trainerDTO.getMediumRate(), trainerDTO.getFitnessCenter(),
                    trainerDTO.getPosition());

            Trainer newTrainer = trainerService.create(trainer);

            TrainerDTO newTrainerDTO = new TrainerDTO(newTrainer.getId(), newTrainer.getFirstName(), newTrainer.getLastName(),
                    newTrainer.getEmail(), newTrainer.getUsername(), newTrainer.getPassword(), newTrainer.getContact(),
                    newTrainer.getBirthDate(), newTrainer.getActive(), newTrainer.getPosition(), newTrainer.getMediumRate(), newTrainer.getFitnessCenter());

            return new ResponseEntity<>(newTrainerDTO, HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainerDTO> updateTrainer(@RequestBody TrainerDTO trainerDTO) throws Exception {

        Trainer trainer = new Trainer(trainerDTO.getFirstName(), trainerDTO.getLastName(), trainerDTO.getUsername(),
                trainerDTO.getContact(), trainerDTO.getEmail(), trainerDTO.getActive());

        Trainer updatedTr = trainerService.update(trainer);

        return null;
    }

    /* Brisanje fitnes centra */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable Long id){
        // Brisemo fitnes centar po ID-ju
        this.trainerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
