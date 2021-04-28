package com.classproject.FitnessCenter.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Training implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "training_name", unique = true, nullable = false)
    private String name;

    @Column(name = "about", length = 120, nullable = false)
    private String aboutTraining;

    @Column(name = "type", nullable = false)
    private String typeOfTraining;

    @Column(name = "length", nullable = false)
    private Integer length;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
