package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RateTraining implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer grade;

    /* Razbijanje @ManyToMany veze izmedju Clana i Termina pomocu nove klase Ocjene */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Member members;

    /* Razbijanje @ManyToMany veze izmedju Clana i Termina pomocu nove klase Ocjene */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Training trainings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Member getMembers() {
        return members;
    }

    public void setMembers(Member members) {
        this.members = members;
    }

    public Training getTrainings() {
        return trainings;
    }

    public void setTrainings(Training trainings) {
        this.trainings = trainings;
    }
}
