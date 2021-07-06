package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.Service.FitnessCenterService;
import com.classproject.FitnessCenter.Service.HallService;
import com.classproject.FitnessCenter.entity.FitnessCenter;
import com.classproject.FitnessCenter.entity.Hall;
import com.classproject.FitnessCenter.entity.dto.HallDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
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
}
