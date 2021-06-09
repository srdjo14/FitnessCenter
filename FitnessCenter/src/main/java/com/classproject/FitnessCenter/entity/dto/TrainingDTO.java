package com.classproject.FitnessCenter.entity.dto;

import com.classproject.FitnessCenter.entity.Terms;
import com.classproject.FitnessCenter.entity.Trainer;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class TrainingDTO {

    private Long id;
    private String name;
    private String aboutTraining;
    private String typeOfTraining;
    private Integer length;
    private List<TermsDTO> termsList;

    public TrainingDTO(Long id, String name, String aboutTraining, String typeOfTraining, Integer length, List<TermsDTO> termsList) {
        this.id = id;
        this.name = name;
        this.aboutTraining = aboutTraining;
        this.typeOfTraining = typeOfTraining;
        this.length = length;
        this.termsList = termsList;
    }

    public TrainingDTO() {}

    public TrainingDTO(Long id, String name, String aboutTraining, String typeOfTraining, Integer length) {
        this.id = id;
        this.name = name;
        this.aboutTraining = aboutTraining;
        this.typeOfTraining = typeOfTraining;
        this.length = length;
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

    public List<TermsDTO> getTermsList() {
        return termsList;
    }

    public void setTermsList(List<TermsDTO> termsList) {
        this.termsList = termsList;
    }
}
