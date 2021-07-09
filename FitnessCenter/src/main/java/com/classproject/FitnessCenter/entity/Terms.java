package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Terms implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Date trainingDay;

    @Column
    private Integer numberCheckedUser;

    /* Razbijanje @ManyToMany veze izmedju Sale i Treninge pomocu nove klase Termina */
    @ManyToOne(fetch = FetchType.EAGER)
    private Hall hall;

    /* Razbijanje @ManyToMany veze izmedju Sale i Treninge pomocu nove klase Termina */
    @ManyToOne(fetch = FetchType.EAGER)
    private Training training;

    /* Druga strana veze 1:n gdje fitnes centar dobija raspored odnosno listu svih termina zajedno sa cijenama */
    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCenter fitnessCenter;

    /* -- LISTA PRIJAVLJENIH TRENINGA -- */
    @OneToMany(mappedBy = "terms", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CheckTraining> checkTraining = new HashSet<>();

    /* -- LISTA ODRADJENIH TRENINGA -- */
    @OneToMany(mappedBy = "terms", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<DoneTraining> doneTraining = new HashSet<>();

    /*        -- LISTA OCJENA ZA ODRADJENE TRENINGE --
    Razbijanje ManyToMany(Clan-Trening) zbog liste ocjena za odradjene treninge,
    pomocu pomocne klase RateTraining.
    Jedan clan moze da ima vise ocijenjenih treninga, a jedan trening moze da ocjeni vise clanova.
        */
    @OneToMany(mappedBy="terms", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RateTraining> rateTraining = new ArrayList<>();


    public Terms(Long id, Double price, Date trainingDay, Training training) {
        this.id = id;
        this.price = price;
        this.trainingDay = trainingDay;
        this.training = training;
    }

    public Terms(Double price, Date trainingDay) {
        this.price = price;
        this.trainingDay = trainingDay;
    }

    public Set<DoneTraining> getDoneTraining() {
        return doneTraining;
    }

    public void setDoneTraining(Set<DoneTraining> doneTraining) {
        this.doneTraining = doneTraining;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(Date trainingDay) {
        this.trainingDay = trainingDay;
    }

    public Integer getNumberCheckedUser() {
        return numberCheckedUser;
    }

    public void setNumberCheckedUser(Integer numberCheckedUser) {
        this.numberCheckedUser = numberCheckedUser;
    }
    
    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public FitnessCenter getFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(FitnessCenter fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public List<RateTraining> getRateTraining() {
        return rateTraining;
    }

    public void setRateTraining(List<RateTraining> rateTraining) {
        this.rateTraining = rateTraining;
    }

    @Override
    public String toString() {
        return "Terms{" +
                "id=" + id +
                ", price=" + price +
                ", trainingDay=" + trainingDay +
                ", numberCheckedUser=" + numberCheckedUser +
                ", hall=" + hall +
                ", training=" + training +
                ", fitnessCenter=" + fitnessCenter +
                '}';
    }

    public Terms() {}

    public Set<CheckTraining> getCheckTraining() {
        return checkTraining;
    }

    public void setCheckTraining(Set<CheckTraining> checkTraining) {
        this.checkTraining = checkTraining;
    }
}
