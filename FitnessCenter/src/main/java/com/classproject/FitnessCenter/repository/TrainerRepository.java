package com.classproject.FitnessCenter.repository;

import com.classproject.FitnessCenter.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    List<Trainer> getAllByActive(Boolean active);
    Trainer findTrainerByUsernameOrId(String par1, String par2);
    Boolean existsTrainerByUsernameOrId(String par1, String par2);
}
