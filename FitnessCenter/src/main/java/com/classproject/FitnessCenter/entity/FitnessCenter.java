package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class FitnessCenter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String address;

    @Column(unique = true)
    private String contactPhone;

    @Column(unique = true)
    private String email;

    /* Prva strana veze 1:n gdje fitnes centar sadrzi listu svih trenera koji postoje */
    @OneToMany(mappedBy = "fitnessCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Trainer> trainers = new ArrayList<>();

    /* Prva strana veze 1:n gdje fitnes centar sadrzi listu svih sala koje se nalaze u njemu */
    @OneToMany(mappedBy = "fitnessCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Hall> hall = new HashSet<>();

    /* Prva strana veze 1:n gdje fitnes centar dobija raspored odnosno listu svih termina zajedno sa cijenama */
    @OneToMany(mappedBy = "fitnessCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Terms> terms = new ArrayList<>();

    public FitnessCenter() {}

    public FitnessCenter(String naziv, String address, String contactPhone, String email) {
        this.naziv = naziv;
        this.address = address;
        this.contactPhone = contactPhone;
        this.email = email;
    }

    public FitnessCenter(Long id, String naziv, String address, String email, String contactPhone) {
        this.id = id;
        this.naziv = naziv;
        this.address = address;
        this.contactPhone = contactPhone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public Set<Hall> getHall() {
        return hall;
    }

    public void setHall(Set<Hall> hall) {
        this.hall = hall;
    }

    public List<Terms> getTerms() {
        return terms;
    }

    public void setTerms(List<Terms> terms) {
        this.terms = terms;
    }
}
