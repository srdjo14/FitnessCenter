package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

enum Type {Continuous,
            Fartlek,
            Circuit,
            Interval,
            Plyometric,
            Flexibility,
            Weight;
          }
@Entity

public class Training implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "training_name", unique = true, nullable = false)
        private String name;

        @Column(name = "about", length = 120, nullable = false)
        private String aboutTraining;

        @Column(name = "type", nullable = false)
        @Enumerated
        private Type typeOfTraining;

        @Column(name = "length", nullable = false)
        private Integer length;

        /* Druga strana veze 1:n gdje svaki trener ima listu treninga koju drzi */
        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private Trainer fitnessTrainer;

        /* Razbijanje @ManyToMany veze izmedju Sale i Treninge pomocu nove klase Termina*/
        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private Terms terms;

        /* Druga strana n:n veze za listu prijavljenih treninga */
        @ManyToMany(mappedBy = "training1")
        private Set<Member> member1 = new HashSet<>();

        /* Druga strana n:n veze za listu odradjenih treninga */
        @ManyToMany(mappedBy = "training1")
        private Set<Member> member2 = new HashSet<>();

        /*
        -- LISTA OCJENA ZA ODRADJENE TRENINGE --
        Razbijanje ManyToMany(CLan-Trening) zbog liste ocjena za odradjene treninge,
        pomocu pomocne klase RateTraining.
        Jedan clan moze da ima vise ocijenjenih treninga, a jedan trening moze da ocjeni vise clanova.
        */
        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private RateTraining rateTraining;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAboutTraining() {
            return aboutTraining;
        }

        public void setAboutTraining(String aboutTraining) {
            this.aboutTraining = aboutTraining;
        }

        public Type getTypeOfTraining() {
            return typeOfTraining;
        }

        public void setTypeOfTraining(Type typeOfTraining) {
            this.typeOfTraining = typeOfTraining;
        }

        public Integer getLength() {
            return length;
        }

        public void setLength(Integer length) {
            this.length = length;
        }

        @Override
        public String toString(){
            return "Training{" +
                    "id=" + id +
                    ", name=" + name + '\'' +
                    ", type=" + typeOfTraining + '\'';
        }
    }


