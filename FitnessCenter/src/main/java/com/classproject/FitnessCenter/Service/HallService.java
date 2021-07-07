package com.classproject.FitnessCenter.Service;

import com.classproject.FitnessCenter.entity.Hall;
import com.classproject.FitnessCenter.entity.dto.HallDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HallService {

    List<Hall> findAll();
    void delete(Long id);

    Hall addHall(Hall hall);

    Hall addHall2(HallDTO hallDTO);

    Optional<Hall> findOne(Long id);

    Hall updateHall(Hall hall);
}
