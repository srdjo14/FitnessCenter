package com.classproject.FitnessCenter.entity.dto;

import com.classproject.FitnessCenter.entity.Training;

import java.util.Date;

public class TermsDTO {



    private Long id;
    private Double price;
    private Date trainingDay;

    public TermsDTO(Long id, Double price, Date trainingDay) {
        this.id = id;
        this.price = price;
        this.trainingDay = trainingDay;
    }

    public TermsDTO() {
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
