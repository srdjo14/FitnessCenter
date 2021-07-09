package com.classproject.FitnessCenter.entity.dto;

import com.classproject.FitnessCenter.entity.CheckTraining;
import com.classproject.FitnessCenter.entity.Member;
import com.classproject.FitnessCenter.entity.Terms;

import java.util.Date;

public class CheckTrainingDTO {
    private Long id;
    private String username;
    private String name;
    private String aboutTraining;
    private String typeOfTraining;
    private Integer length;
    private Double price;
    private Date trainingDay;
    private Member member;
    private Terms terms;

    public CheckTrainingDTO() {}

    public CheckTrainingDTO(Long id, String username, String name, String aboutTraining, String typeOfTraining, Integer length, Double price, Date trainingDay) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.aboutTraining = aboutTraining;
        this.typeOfTraining = typeOfTraining;
        this.length = length;
        this.price = price;
        this.trainingDay = trainingDay;
    }

    public CheckTrainingDTO(Long id, Member members, Terms terms) {
        this.id = id;
        this.member = members;
        this.terms = terms;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Terms getTerms() {
        return terms;
    }

    public void setTerms(Terms terms) {
        this.terms = terms;
    }

    public String getAboutTraining() {
        return aboutTraining;
    }

    public void setAboutTraining(String aboutTraining) {
        this.aboutTraining = aboutTraining;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
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
