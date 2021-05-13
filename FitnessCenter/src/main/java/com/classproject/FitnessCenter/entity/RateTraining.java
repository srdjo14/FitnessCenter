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
    @OneToMany(mappedBy = "rateTraining", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Member> members = new HashSet<>();

    /* Razbijanje @ManyToMany veze izmedju Clana i Termina pomocu nove klase Ocjene */
    @OneToMany(mappedBy = "rateTraining", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Training> trainings = new HashSet<>();

}
