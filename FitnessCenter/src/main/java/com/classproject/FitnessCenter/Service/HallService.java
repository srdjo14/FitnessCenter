package com.classproject.FitnessCenter.Service;

import com.classproject.FitnessCenter.entity.Hall;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HallService {

    List<Hall> findAll();
    void delete(Long id);

}
