package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.Service.FitnessCenterService;
import com.classproject.FitnessCenter.Service.HallService;
import com.classproject.FitnessCenter.entity.FitnessCenter;
import com.classproject.FitnessCenter.entity.Hall;
import com.classproject.FitnessCenter.entity.dto.FitnessCenterDTO;
import com.classproject.FitnessCenter.entity.dto.HallDTO;
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
@RequestMapping(value="/api/hall")
public class HallController {

    private HallService hallService;
    private FitnessCenterService fitnessCenterService;

    @Autowired
    public HallController(HallService hallService, FitnessCenterService fitnessCenterService) {
        this.hallService = hallService;
        this.fitnessCenterService = fitnessCenterService;

    }

    @GetMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HallDTO>> getHall(){
        List<Hall> hallList = hallService.findAll();
        List<HallDTO> hallDTOList = new ArrayList<>();
        FitnessCenter fc = new FitnessCenter();

        for(Hall hall : hallList) {
            HallDTO hallDTO = new HallDTO(hall.getId(), hall.getCapacity(), hall.getNumberOfHall(), hall.getFitnessCenter().getId());
            hallDTOList.add(hallDTO);
        }
        return new ResponseEntity<>(hallDTOList, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HallDTO> createHall(@RequestBody HallDTO hallDTO) throws Exception {
        Hall hall = hallService.addHall2(hallDTO);
        hallDTO.setId(hall.getId());
        return new ResponseEntity<>(hallDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HallDTO> updateHall(@PathVariable Long id, @Validated @RequestBody HallDTO hallDTO) throws Exception{
        Optional<Hall> hall1 = hallService.findOne(id);

        FitnessCenter fitnessCenter = new FitnessCenter();
        fitnessCenter = fitnessCenterService.findOneById(hallDTO.getFitnessCenterId());
        Hall hall = new Hall(
                hall1.get().getId(),
                hallDTO.getCapacity(),
                hallDTO.getNumberOfHall(),
                fitnessCenter
        );
                hall = hallService.updateHall(hall);
            hallDTO.setId(id);
            return new ResponseEntity<>(hallDTO, HttpStatus.ACCEPTED);


    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteFC(@PathVariable Long id){
        hallService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
