package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.HallService;
import com.classproject.FitnessCenter.entity.Hall;
import com.classproject.FitnessCenter.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public List<Hall> findAll() {
        return hallRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        hallRepository.deleteById(id);
    }
}
