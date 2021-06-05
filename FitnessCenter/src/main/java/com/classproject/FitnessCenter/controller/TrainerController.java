package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.Service.MemberService;
import com.classproject.FitnessCenter.Service.TrainerService;
import com.classproject.FitnessCenter.entity.Member;
import com.classproject.FitnessCenter.entity.Trainer;
import com.classproject.FitnessCenter.entity.dto.MemberDTO;
import com.classproject.FitnessCenter.entity.dto.TrainerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/trainer")
public class TrainerController {
    private final TrainerService trainerService;

    /* Constructor-based dependency injection */
    @Autowired
    public TrainerController(TrainerService trainerService) {this.trainerService = trainerService; }

    /* Metoda za registraciju novog clana fitnes centra */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainerDTO> createTrainer(@RequestBody TrainerDTO trainerDTO) throws Exception {
        Trainer trainer = new Trainer(trainerDTO.getId(), trainerDTO.getPosition(), trainerDTO.getFirstName(), trainerDTO.getLastName(), trainerDTO.getUsername(),
                trainerDTO.getPassword(), trainerDTO.getEmail(), trainerDTO.getBirthDate(), trainerDTO.getContact() );

        Trainer newTrainer = trainerService.create(trainer);

        TrainerDTO newTrainerDTO = new TrainerDTO(newTrainer.getId(), newTrainer.getPosition(), newTrainer.getFirstName(), newTrainer.getLastName(),
                newTrainer.getEmail(), newTrainer.getUsername(), newTrainer.getPassword(), newTrainer.getContact(),
                newTrainer.getBirthDate());

        return new ResponseEntity<>(newTrainerDTO, HttpStatus.CREATED);
    }
}
