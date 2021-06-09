package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.Service.AuthenticationService;
import com.classproject.FitnessCenter.Service.TrainingService;
import com.classproject.FitnessCenter.Service.UserService;
import com.classproject.FitnessCenter.entity.Training;
import com.classproject.FitnessCenter.entity.User;
import com.classproject.FitnessCenter.entity.dto.TrainingDTO;
import com.classproject.FitnessCenter.entity.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
    U klasi UserController cemo definisati i implementirati sve metode
    koje su zajednicke svim korisnicima fitnes centra, tacnije nije
    nam bitna njihova uloga.
*/
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final UserService userService;
    private final TrainingService trainingService;
    private final AuthenticationService authenticationService;
    private Object Exception = "Nije prijavljen korisnik";

    @Autowired
    public UserController(UserService userService, TrainingService trainingService, AuthenticationService authenticationService){
        this.userService = userService;
        this.trainingService = trainingService;
        this.authenticationService = authenticationService;
    }

    @GetMapping(value = "/training", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrainingDTO>> getTraining() {


            // Pozivanjem metode servisa dobavljamo sve treninge
            List<Training> trainingList = this.trainingService.findAll();

            List<TrainingDTO> trainingDTOS = new ArrayList<>();

            for (Training training : trainingList) {
                TrainingDTO trainingDTO = new TrainingDTO(training.getId(), training.getName(), training.getAboutTraining(),
                        training.getTypeOfTraining(), training.getLength());
                trainingDTOS.add(trainingDTO);
            }

            // Vraćamo odgovor 200 OK, a kroz body odgovora šaljemo podatke o pronađenim zaposlenima
            return new ResponseEntity<>(trainingDTOS, HttpStatus.OK);

    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) throws Exception {
        User user = new User(userDTO.getUsername(), userDTO.getPassword());

        User newUser = userService.create(user);

        UserDTO newUserDTO = new UserDTO(newUser.getUsername(), newUser.getPassword());

        return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);
    }

}
