package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
//ovom anotacijom se navodi vrednost diskriminatorske kolone koja vazi za
//objekte ove klase
@DiscriminatorValue("TRAINER")
public class Trainer extends User implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        /* Prva strana veze 1:n gdje svaki trener ima listu treninga koju drzi */
        @OneToMany(mappedBy = "fitnessTrainer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Training> MyTrainings = new HashSet<>();

        /* Druga strana veze 1:n gdje fitnes centar sadrzi listu svih trenera koji postoje */
        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private FitnessCenter fitnessCenter;

        /* Prosjecna ocjena */
        private Double mediumRate;

        public Trainer(Long id, String firstName, String lastName, String username, String password, String contact, String email, Date birthDate, String typeOfUser) {
                super();
        }

        @Override
        public Long getId() {
                return id;
        }

        @Override
        public void setId(Long id) {
                this.id = id;
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
                        "id=" + id +
                        ", MyTrainings=" + MyTrainings +
                        ", fitnessCenter=" + fitnessCenter +
                        ", mediumRate=" + mediumRate +
                        '}';
        }
}
