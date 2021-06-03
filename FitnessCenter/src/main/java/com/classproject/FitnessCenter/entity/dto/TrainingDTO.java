package com.classproject.FitnessCenter.entity.dto;

public class TrainingDTO {

    private Long id;
    private String name;
    private String aboutTraining;
    private String typeOfTraining;
    private Integer length;

    public TrainingDTO(){}
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
}
