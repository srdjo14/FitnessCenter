package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "trainer")
//ovom anotacijom se navodi vrednost diskriminatorske kolone koja vazi za
//objekte ove klase
@DiscriminatorValue("TRAINER")
public class Trainer extends User implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Training> MyTrainings = new HashSet<>();

        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private FitnessCenter fitnessCenter;


}
