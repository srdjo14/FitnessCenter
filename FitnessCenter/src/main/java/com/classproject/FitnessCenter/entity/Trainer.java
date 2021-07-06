package com.classproject.FitnessCenter.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@DiscriminatorValue("trainer")
public class Trainer extends User implements Serializable{

        /* Prva strana veze 1:n gdje svaki trener ima listu treninga koju drzi */
        @OneToMany(mappedBy = "fitnessTrainer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Training> MyTrainings = new HashSet<>();

        /* Druga strana veze 1:n gdje fitnes centar sadrzi listu svih trenera koji postoje */
        @ManyToOne(fetch = FetchType.EAGER)
        private FitnessCenter fitnessCenter;

        /* Prosjecna ocjena */
        private Double mediumRate;

        public Trainer() {
        }

    public Trainer(String firstName, String lastName, String username, String password, String email, String contact, Date birthDate, Boolean active, Double mediumRate, FitnessCenter fitnessCenter, String position) {
        super(firstName, lastName, username, password, email, contact, birthDate, active, position);
        this.mediumRate = mediumRate;
        this.fitnessCenter = fitnessCenter;
    }



    public Trainer(String firstName, String lastName, String username, String contact, String email, Boolean active) {
    }


    public Set<Training> getMyTrainings() {
                return MyTrainings;
        }

        public void setMyTrainings(Set<Training> myTrainings) {
                MyTrainings = myTrainings;
        }

        public FitnessCenter getFitnessCenter() {
                return fitnessCenter;
        }

        public void setFitnessCenter(FitnessCenter fitnessCenter) {
                this.fitnessCenter = fitnessCenter;
        }

        public Double getMediumRate() {
                return mediumRate;
        }

        public void setMediumRate(Double mediumRate) {
                this.mediumRate = mediumRate;
        }

        @Override
        public String toString() {
                return "Trainer{" +
                        ", MyTrainings=" + MyTrainings +
                        ", fitnessCenter=" + fitnessCenter +
                        ", mediumRate=" + mediumRate +
                        '}';
        }
}
