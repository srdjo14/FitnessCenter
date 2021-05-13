package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("USER")
public class Member extends User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     -- LISTA OCJENA ZA ODRADJENE TRENINGE --
     Razbijanje ManyToMany zbog liste ocjena za odradjene treninge,
     pomocu pomocne klase RateTraining.
     Jedan clan moze da ima vise ocijenjenih treninga, a jedan trening moze da ocjeni vise clanova.
    */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private RateTraining rateTraining;

    /* -- LISTA PRIJAVLJENIH TRENINGA --
        Koristenje direktne MTM veze.
    */
    @ManyToMany
    @JoinTable(name = "checked-in",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "training_id", referencedColumnName = "id"))
    private Set<Training> training1 = new HashSet<>();

    /* -- LISTA ODRADJENIH TRENINGA --
        Koristenje direktne MTM veze.
    */
    @ManyToMany
    @JoinTable(name = "finished",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "training_id", referencedColumnName = "id"))
    private Set<Training> training2 = new HashSet<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public RateTraining getRateTraining() {
        return rateTraining;
    }

    public void setRateTraining(RateTraining rateTraining) {
        this.rateTraining = rateTraining;
    }

    public Set<Training> getTraining1() {
        return training1;
    }

    public void setTraining1(Set<Training> training1) {
        this.training1 = training1;
    }

    public Set<Training> getTraining2() {
        return training2;
    }

    public void setTraining2(Set<Training> training2) {
        this.training2 = training2;
    }
}
