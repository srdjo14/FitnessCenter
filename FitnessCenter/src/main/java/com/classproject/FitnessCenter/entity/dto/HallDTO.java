package com.classproject.FitnessCenter.entity.dto;

import com.classproject.FitnessCenter.entity.FitnessCenter;

import javax.persistence.*;

public class HallDTO {

    private Long id;
    private Integer capacity;
    private String numberOfHall;
    private Long fitnessCenterId;

    public HallDTO() {}

    public HallDTO(Long id, Integer capacity, String numberOfHall, Long fitnessCenterId) {
        this.id = id;
        this.capacity = capacity;
        this.numberOfHall = numberOfHall;
        this.fitnessCenterId = fitnessCenterId;
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

    public Long getFitnessCenterId() {
        return fitnessCenterId;
    }

    public void setFitnessCenterId(Long fitnessCenterId) {
        this.fitnessCenterId = fitnessCenterId;
    }
}
