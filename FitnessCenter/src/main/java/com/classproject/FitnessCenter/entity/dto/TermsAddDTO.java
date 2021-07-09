package com.classproject.FitnessCenter.entity.dto;

import com.classproject.FitnessCenter.entity.FitnessCenter;
import com.classproject.FitnessCenter.entity.Hall;
import com.classproject.FitnessCenter.entity.Training;

import java.util.Date;

public class TermsAddDTO {

    private Long id;
    private Double price;
    private Date trainingDay;
    private Long fitnessCenter;
    private Long hall;
    private Long training;
    private Integer numberCheckedUser;

    public TermsAddDTO() {
    }

    public TermsAddDTO(Long id, Double price, Date trainingDay, Long fitnessCenterId, Long hallId, Long trainingId, Integer numberCheckedUser) {
        this.id = id;
        this.price = price;
        this.trainingDay = trainingDay;
        this.fitnessCenter = fitnessCenterId;
        this.hall = hallId;
        this.training = trainingId;
        this.numberCheckedUser = numberCheckedUser;
    }

    public TermsAddDTO(Long id, Integer numberCheckedUser, Double price, Long fitnessCenter, Long hall, Long training) {
        this.id = id;
        this.numberCheckedUser = numberCheckedUser;
        this.price = price;
        this.fitnessCenter = fitnessCenter;
        this.hall = hall;
        this.training = training;


    }

    public Integer getNumberCheckedUser() {
        return numberCheckedUser;
    }

    public void setNumberCheckedUser(Integer numberCheckedUser) {
        this.numberCheckedUser = numberCheckedUser;
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

    public Long getFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(Long fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }

    public Long getHall() {
        return hall;
    }

    public void setHall(Long hall) {
        this.hall = hall;
    }

    public Long getTraining() {
        return training;
    }

    public void setTraining(Long training) {
        this.training = training;
    }
}
