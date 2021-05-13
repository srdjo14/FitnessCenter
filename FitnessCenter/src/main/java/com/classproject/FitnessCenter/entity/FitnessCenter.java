package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FitnessCenter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private Integer contactPhone;

    @Column(nullable = false, unique = true)
    private String email;

    /* Prva strana veze 1:n gdje fitnes centar sadrzi listu svih trenera koji postoje */
    @OneToMany(mappedBy = "fitnessCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trainer> trainers = new HashSet<>();

    /* Prva strana veze 1:n gdje fitnes centar sadrzi listu svih sala koje se nalaze u njemu */
    @OneToMany(mappedBy = "fitnessCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Hall> hall = new HashSet<>();

    /* Prva strana veze 1:n gdje fitnes centar dobija raspored odnosno listu svih termina zajedno sa cijenama */
    @OneToMany(mappedBy = "fitnessCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Terms> terms = new HashSet<>();

}
