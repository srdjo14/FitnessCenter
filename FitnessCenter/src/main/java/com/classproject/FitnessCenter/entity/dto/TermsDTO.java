package com.classproject.FitnessCenter.entity.dto;

import com.classproject.FitnessCenter.entity.Training;

import java.util.Date;

public class TermsDTO {

    private final String name;
    private final String typeOfTraining;
    private final String aboutTraining;

    private Long id;
    private Training training;
    private Double price;
    private Date trainingDay;



    public TermsDTO(String name, String typeOfTraining, String aboutTraining, Long id, Training training, Double price, Date trainingDay) {
        this.name = name;
        this.typeOfTraining = typeOfTraining;
        this.aboutTraining = aboutTraining;
        this.id = id;
        this.training = training;
        this.price = price;
        this.trainingDay = trainingDay;
    }

    public TermsDTO(Long id, String name, String aboutTraining, String typeOfTraining, Double price, Date trainingDay) {
        this.id = id;
        this.name = name;
        this.aboutTraining = aboutTraining;
        this.typeOfTraining = typeOfTraining;
        this.price = price;
        this.trainingDay = trainingDay;
    }

    public String getName() {
        return name;
    }

    public String getTypeOfTraining() {
        return typeOfTraining;
    }

    public String getAboutTraining() {
        return aboutTraining;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(Date trainingDay) {
        this.trainingDay = trainingDay;
    }
}
