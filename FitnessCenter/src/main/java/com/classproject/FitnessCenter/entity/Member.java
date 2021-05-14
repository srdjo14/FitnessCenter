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
    @OneToMany(mappedBy="members", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RateTraining> rateTraining = new ArrayList<>();

    /* -- LISTA PRIJAVLJENIH TRENINGA --
        Koristenje direktne MTM veze.
    */
    @OneToMany(mappedBy = "members", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CheckTraining> checkTraining = new ArrayList<>();

    /* -- LISTA ODRADJENIH TRENINGA --
        Druga strana 1:n veze izmedju odradjenih treninga i clana.
    */
    @OneToMany(mappedBy = "members", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CheckTraining> doneTraining = new ArrayList<>();


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public List<RateTraining> getRateTraining() {
        return rateTraining;
    }

    public void setRateTraining(List<RateTraining> rateTraining) {
        this.rateTraining = rateTraining;
    }

    public List<CheckTraining> getCheckTraining() {
        return checkTraining;
    }

    public void setCheckTraining(List<CheckTraining> checkTraining) {
        this.checkTraining = checkTraining;
    }

    public List<CheckTraining> getDoneTraining() {
        return doneTraining;
    }

    public void setDoneTraining(List<CheckTraining> doneTraining) {
        this.doneTraining = doneTraining;
    }
}
