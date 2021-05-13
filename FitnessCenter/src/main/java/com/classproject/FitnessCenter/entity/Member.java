package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("USER")
public class Member extends User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     -- LISTA OCJENA ZA ODRADJENE TRENINGE --
     Razbijanje ManyToMany zbog liste ocjena za odradjene treninge,
     pomocu pomocne klase RateTraining.
     Jedan clan moze da ima vise ocijenjenih treninga, a jedan trening moze da ocjeni vise clanova.
    */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private RateTraining rateTraining;

    /* -- LISTA PRIJAVLJENIH TRENINGA --
        Koristenje direktne MTM veze.
    */
    @ManyToMany
    @JoinTable(name = "checked-in",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "training_id", referencedColumnName = "id"))
    private Set<Training> training1 = new HashSet<>();

    /* -- LISTA ODRADJENIH TRENINGA --
        Koristenje direktne MTM veze.
    */
    @ManyToMany
    @JoinTable(name = "finished",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "training_id", referencedColumnName = "id"))
    private Set<Training> training2 = new HashSet<>();

}
