package com.classproject.FitnessCenter.entity.dto;

import com.classproject.FitnessCenter.entity.FitnessCenter;

import java.util.Date;

public class TrainerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String contact;
    private Date birthDate;
    private Boolean active;
    private String position = "trainer";
    private Double mediumRate = 0.0;
    private FitnessCenter fitnessCenter;

    public TrainerDTO(Long id, String firstName, String lastName, String username, String password, String email, String contact, Date birthDate, Boolean active, String position, Double mediumRate, FitnessCenter fitnessCenter) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.birthDate = birthDate;
        this.active = active;
        this.position = position;
        this.mediumRate = mediumRate;
        this.fitnessCenter = fitnessCenter;
    }

    public TrainerDTO() {
    }

    public TrainerDTO(Long id, String firstName, String lastName, String username, String contact, String email, Boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.contact = contact;
        this.email = email;
        this.active = active;
    }

    public TrainerDTO(Long id, String firstName, String lastName, FitnessCenter fitnessCenter) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fitnessCenter = fitnessCenter;
    }

    public TrainerDTO(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getMediumRate() {
        return mediumRate;
    }

    public void setMediumRate(Double mediumRate) {
        this.mediumRate = mediumRate;
    }

    public FitnessCenter getFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(FitnessCenter fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
