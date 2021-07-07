package com.classproject.FitnessCenter.entity.dto;

import com.classproject.FitnessCenter.entity.CheckTraining;

public class CheckTrainingDTO {
    private Long id;
    private String username;
    private String name;
    private String typeOfTraining;

    public CheckTrainingDTO() {}

    public CheckTrainingDTO(Long id, String username, String name, String typeOfTraining) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.typeOfTraining = typeOfTraining;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfTraining() {
        return typeOfTraining;
    }

    public void setTypeOfTraining(String typeOfTraining) {
        this.typeOfTraining = typeOfTraining;
    }
}
