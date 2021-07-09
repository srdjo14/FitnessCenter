package com.classproject.FitnessCenter.entity;

import com.classproject.FitnessCenter.entity.dto.RateTrainingDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
    @ManyToOne(fetch = FetchType.EAGER)
    private Member members;

    /* Razbijanje @ManyToMany veze izmedju Clana i Termina pomocu nove klase Ocjene */
    @ManyToOne(fetch = FetchType.EAGER)
    private Terms terms;

    public RateTraining(Long id, String name, String aboutTraining, String typeOfTraining, Integer length, Double price, Date trainingDay, Integer grade) {
    }

    public RateTraining(Integer grade, Member member, Terms terms) {
        this.grade = grade;
        this.members = member;
        this.terms = terms;
    }

    public RateTraining() {}

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

    public Terms getTerms() {
        return terms;
    }

    public void setTerms(Terms terms) {
        this.terms = terms;
    }
}
