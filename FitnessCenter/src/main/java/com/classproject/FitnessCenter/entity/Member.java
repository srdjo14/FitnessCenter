package com.classproject.FitnessCenter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@DiscriminatorValue("member")
public class Member extends User{

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

    public Member() {}
    public Member(Long id, Position position, String firstName, String lastName, String username, String password, String email, Date birthDate, String contact) {

    }

    public Member(Position position, String firstName, String lastName, String username, String password, String email, Date birthDate, String contact) {
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
