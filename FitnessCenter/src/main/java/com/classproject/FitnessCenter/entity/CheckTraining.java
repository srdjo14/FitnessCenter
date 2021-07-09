package com.classproject.FitnessCenter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CheckTraining implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* Razbijanje @ManyToMany veze izmedju Clana i Treninga pomocu nove klase Check */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Member members;

    /* Razbijanje @ManyToMany veze izmedju Clana i Treninga pomocu nove klase Check */

    @ManyToOne(fetch = FetchType.LAZY)
    private Terms terms;

    public CheckTraining() {}

    public CheckTraining(Member members, Terms terms) {
        this.members = members;
        this.terms = terms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

