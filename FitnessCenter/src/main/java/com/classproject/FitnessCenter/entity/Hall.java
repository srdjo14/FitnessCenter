package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import javax.print.DocFlavor;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Hall implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer capacity;

    @Column
    private String numberOfHall;

    /* Druga strana veze 1:n gdje fitnes centar sadrzi listu svih sala koje se nalaze u njemu */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnessCenter fitnessCenter;

    /* Razbijanje @ManyToMany veze izmedju Sale i Treninge pomocu nove klase Termina */
    @OneToMany(mappedBy = "hall", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Terms> terms = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getNumberOfHall() {
        return numberOfHall;
    }

    public void setNumberOfHall(String numberOfHall) {
        this.numberOfHall = numberOfHall;
    }

    public FitnessCenter getFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(FitnessCenter fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }

}
