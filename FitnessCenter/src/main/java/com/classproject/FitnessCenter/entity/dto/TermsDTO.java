package com.classproject.FitnessCenter.entity.dto;

import com.classproject.FitnessCenter.entity.Training;

import java.util.Date;

public class TermsDTO {

    private Long id;
    private Double price;
    private Date trainingDay;
    private Long trainingId;
    private String name;
    private String aboutTraining;
    private String typeOfTraining;
    private Integer length;
    private Integer capacity;

    public TermsDTO(Long id, Double price, Date trainingDay) {
        this.id = id;
        this.price = price;
        this.trainingDay = trainingDay;
    }

    public TermsDTO(Long id, Double price, Date trainingDay, Long trainingId) {
        this.id = id;
        this.price = price;
        this.trainingDay = trainingDay;
        this.trainingId = trainingId;
    }
    public TermsDTO() {
    }

    public TermsDTO(Long id, Date trainingDay, Double price, String name, String aboutTraining, String typeOfTraining, Integer length) {
        this.id = id;
        this.trainingDay = trainingDay;
        this.price = price;
        this.name = name;
        this.aboutTraining = aboutTraining;
        this.typeOfTraining = typeOfTraining;
        this.length = length;
    }

    public TermsDTO(Long id, Double price, Date trainingDay, Long trainingId, String name, String aboutTraining, String typeOfTraining, Integer length, Integer capacity) {
        this.id = id;
        this.price = price;
        this.trainingDay = trainingDay;
        this.trainingId = trainingId;
        this.name = name;
        this.aboutTraining = aboutTraining;
        this.typeOfTraining = typeOfTraining;
        this.length = length;
        this.capacity = capacity;
    }

    public TermsDTO(Long id, Date trainingDay, Double price, String name, String aboutTraining, String typeOfTraining, Integer length, Integer capacity) {
        this.id = id;
        this.trainingDay = trainingDay;
        this.price = price;
        this.name = name;
        this.aboutTraining = aboutTraining;
        this.typeOfTraining = typeOfTraining;
        this.length = length;
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
