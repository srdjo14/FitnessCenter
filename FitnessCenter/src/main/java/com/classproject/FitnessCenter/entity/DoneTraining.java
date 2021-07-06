package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DoneTraining implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* Razbijanje @ManyToMany veze izmedju Clana i Treninga pomocu nove klase Check */
    @ManyToOne(fetch = FetchType.EAGER)
    private Member members;

    /* Razbijanje @ManyToMany veze izmedju Clana i Treninga pomocu nove klase Check */
    @ManyToOne(fetch = FetchType.EAGER)
    private Training training;
}