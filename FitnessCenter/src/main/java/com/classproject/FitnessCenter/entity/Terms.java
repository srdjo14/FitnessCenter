package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Terms implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Date trainingDay;

    @Column(nullable = false)
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
}
