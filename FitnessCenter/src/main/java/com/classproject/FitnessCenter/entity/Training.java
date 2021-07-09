package com.classproject.FitnessCenter.entity;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        private String typeOfTraining;

        @Column(name = "length", nullable = false)
        private Integer length;

        /* Druga strana veze 1:n gdje svaki trener ima listu treninga koju drzi */
        @ManyToOne(fetch = FetchType.EAGER)
        private Trainer fitnessTrainer;

        /* Razbijanje @ManyToMany veze izmedju Sale i Treninge pomocu nove klase Termina*/
        @OneToMany(mappedBy = "training", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Terms> terms = new HashSet<>();




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

    public String getTypeOfTraining() {
        return typeOfTraining;
    }

    public void setTypeOfTraining(String typeOfTraining) {
        this.typeOfTraining = typeOfTraining;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Trainer getFitnessTrainer() {
        return fitnessTrainer;
    }

    public void setFitnessTrainer(Trainer fitnessTrainer) {
        this.fitnessTrainer = fitnessTrainer;
    }

    public Set<Terms> getTerms() {
        return terms;
    }

    public void setTerms(Set<Terms> terms) {
        this.terms = terms;
    }



    @Override
        public String toString(){
            return "Training{" +
                    "id=" + id +
                    ", name=" + name + '\'' +
                    ", type=" + typeOfTraining + '\'';
        }
    }


