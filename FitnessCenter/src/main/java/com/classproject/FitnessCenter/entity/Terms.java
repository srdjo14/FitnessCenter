package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Terms implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double price;

    @Column
    private Date trainingDay;

    @Column
    private Integer numberCheckedUser;

    /* Razbijanje @ManyToMany veze izmedju Sale i Treninge pomocu nove klase Termina */
    @OneToMany(mappedBy = "terms", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Hall> hall = new HashSet<>();

    /* Razbijanje @ManyToMany veze izmedju Sale i Treninge pomocu nove klase Termina */
    @OneToMany(mappedBy = "terms", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Training> training = new HashSet<>();

    /* Druga strana veze 1:n gdje fitnes centar dobija raspored odnosno listu svih termina zajedno sa cijenama */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnessCenter fitnessCenter;

}
