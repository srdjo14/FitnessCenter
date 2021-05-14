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

    @Column(nullable = false)
    private String naziv;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String contactPhone;

    @Column(nullable = false, unique = true)
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
