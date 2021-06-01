package com.classproject.FitnessCenter.entity.dto;

import com.classproject.FitnessCenter.entity.FitnessCenter;

public class TrainerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private FitnessCenter fitnessCenter;
    private Double mediumRate;

    public TrainerDTO() {}

    public TrainerDTO(Long id, String firstName, String lastName, String username, FitnessCenter fitnessCenter, Double mediumRate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.fitnessCenter = fitnessCenter;
        this.mediumRate = mediumRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getMediumRate() {
        return mediumRate;
    }

    public void setMediumRate(Double mediumRate) {
        this.mediumRate = mediumRate;
    }

    public FitnessCenter getFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(FitnessCenter fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }
}
