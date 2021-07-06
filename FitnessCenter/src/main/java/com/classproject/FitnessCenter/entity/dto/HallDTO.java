package com.classproject.FitnessCenter.entity.dto;

import com.classproject.FitnessCenter.entity.FitnessCenter;

import javax.persistence.*;

public class HallDTO {

    private Long id;
    private Integer capacity;
    private String numberOfHall;
    private FitnessCenter fitnessCenter;

    public HallDTO() {}

    public HallDTO(Long id, Integer capacity, String numberOfHall, FitnessCenter fitnessCenter) {
        this.id = id;
        this.capacity = capacity;
        this.numberOfHall = numberOfHall;
        this.fitnessCenter = fitnessCenter;
    }

    public HallDTO(Long id, Integer capacity, String numberOfHall, Long id1) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getNumberOfHall() {
        return numberOfHall;
    }

    public void setNumberOfHall(String numberOfHall) {
        this.numberOfHall = numberOfHall;
    }

    public FitnessCenter getFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(FitnessCenter fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }
}
