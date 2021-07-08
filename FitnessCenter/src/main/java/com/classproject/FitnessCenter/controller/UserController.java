package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.Service.*;
import com.classproject.FitnessCenter.entity.Terms;
import com.classproject.FitnessCenter.entity.Training;
import com.classproject.FitnessCenter.entity.User;
import com.classproject.FitnessCenter.entity.dto.LoginDTO;
import com.classproject.FitnessCenter.entity.dto.TermsDTO;
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
    private final TermsService termsService;
    private final TrainerService trainerService;

    @Autowired
    public UserController(UserService userService, TrainingService trainingService, AuthenticationService authenticationService, TermsService termsService, TrainerService trainerService){
        this.userService = userService;
        this.trainingService = trainingService;
        this.authenticationService = authenticationService;
        this.termsService = termsService;
        this.trainerService = trainerService;
    }
    @GetMapping(value = "/training/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainingDTO> getOneTraining(@PathVariable("id") Long id){
        Training training = this.trainingService.findOne(id);

        TrainingDTO trainingDTO = new TrainingDTO();
        trainingDTO.setId(training.getId());
        trainingDTO.setName(training.getName());
        trainingDTO.setAboutTraining(training.getAboutTraining());
        trainingDTO.setTypeOfTraining(training.getTypeOfTraining());
        trainingDTO.setLength(training.getLength());

        return new ResponseEntity<>(trainingDTO, HttpStatus.OK);
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

    /* Dobavljanje svih termina */
    @GetMapping(value = "/terms", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TermsDTO>> getTerms(){

        List<Terms> termsList = this.termsService.findAll();
        List<TermsDTO> termsDTOS = new ArrayList<>();

        for (Terms terms : termsList) {
            TermsDTO termsDTO = new TermsDTO(
            terms.getId(),
            terms.getTrainingDay(),
            terms.getPrice(),
            terms.getTraining().getName(),
            terms.getTraining().getAboutTraining(),
            terms.getTraining().getTypeOfTraining(),
            terms.getTraining().getLength()
            );
            termsDTOS.add(termsDTO);
        }
        return new ResponseEntity<>(termsDTOS, HttpStatus.OK);
    }

    /* Dobavljanje odabranog termina */
    @GetMapping(value = "/odabran/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TermsDTO> getOdabraniTermin(@PathVariable Long id){

        Terms terms = termsService.findOneById(id);
        if(terms==null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        TermsDTO termsDTO = new TermsDTO(
                terms.getId(),
                terms.getTrainingDay(),
                terms.getPrice(),
                terms.getTraining().getName(),
                terms.getTraining().getAboutTraining(),
                terms.getTraining().getTypeOfTraining(),
                terms.getTraining().getLength(),
                terms.getHall().getCapacity()-terms.getNumberCheckedUser()
        );

        return new ResponseEntity<>(termsDTO,HttpStatus.OK);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@RequestBody LoginDTO loginDTO) throws Exception {
        User user = userService.loginUser(loginDTO);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getContact(),
                user.getEmail(),user.getBirthDate(), user.getActive(), user.getPosition());

        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "jedan/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id){
        User user = this.userService.findOne(id);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPosition(user.getPosition());

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
