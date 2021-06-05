package com.classproject.FitnessCenter.entity.dto;

import com.classproject.FitnessCenter.entity.Trainer;

public class TrainingDTO {

    private Long id;
    private String name;
    private String aboutTraining;
    private String typeOfTraining;
    private Integer length;
    private Trainer fitnessTrainer;

    public TrainingDTO(){}
    public TrainingDTO(Long id, String name, String aboutTraining, String typeOfTraining, Integer length, Trainer fitnessTrainer) {
        this.id = id;
        this.name = name;
        this.aboutTraining = aboutTraining;
        this.typeOfTraining = typeOfTraining;
        this.length = length;
        this.fitnessTrainer = fitnessTrainer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAboutTraining() {
        return aboutTraining;
    }

    public void setAboutTraining(String aboutTraining) {
        this.aboutTraining = aboutTraining;
    }

    public String getTypeOfTraining() {
        return typeOfTraining;
    }

    public void setTypeOfTraining(String typeOfTraining) {
        this.typeOfTraining = typeOfTraining;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Trainer getFitnessTrainer() {
        return fitnessTrainer;
    }

    public void setFitnessTrainer(Trainer fitnessTrainer) {
        this.fitnessTrainer = fitnessTrainer;
    }
}
