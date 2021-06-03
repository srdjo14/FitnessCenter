package com.classproject.FitnessCenter.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
//ovom anotacijom se navodi vrednost diskriminatorske kolone koja vazi za
//objekte ove klase
@DiscriminatorValue("trainer")
public class Trainer extends User implements Serializable{

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


        public Trainer() {
        }

        public Trainer(Long id, String typeOfUser, String firstName, String lastName, String username, String password, String email, Date birthDate, String contact) {
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
