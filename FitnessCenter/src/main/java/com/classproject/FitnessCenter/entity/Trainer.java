package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//ovom anotacijom se navodi vrednost diskriminatorske kolone koja vazi za
//objekte ove klase
@DiscriminatorValue("TRAINER")
public class Trainer extends User implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        /* Prva strana veze 1:n gdje svaki trener ima listu treninga koju drzi */
        @OneToMany(mappedBy = "fitnessTrainer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Training> MyTrainings = new HashSet<>();

        /* Druga strana veze 1:n gdje fitnes centar sadrzi listu svih trenera koji postoje */
        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private FitnessCenter fitnessCenter;

        /* Prosjecna ocjena */


}
