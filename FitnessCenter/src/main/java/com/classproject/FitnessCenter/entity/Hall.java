package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Hall implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer capacity;

    @Column
    private Integer numberOfHall;

    /* Druga strana veze 1:n gdje fitnes centar sadrzi listu svih sala koje se nalaze u njemu */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnessCenter fitnessCenter;

    /* Razbijanje @ManyToMany veze izmedju Sale i Treninge pomocu nove klase Termina */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Terms terms;

}
