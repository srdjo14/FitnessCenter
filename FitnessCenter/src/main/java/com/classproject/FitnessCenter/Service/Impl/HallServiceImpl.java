package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.FitnessCenterService;
import com.classproject.FitnessCenter.Service.HallService;
import com.classproject.FitnessCenter.entity.FitnessCenter;
import com.classproject.FitnessCenter.entity.Hall;
import com.classproject.FitnessCenter.entity.dto.HallDTO;
import com.classproject.FitnessCenter.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;
    private final FitnessCenterService fitnessCenterService;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository, FitnessCenterService fitnessCenterService) {
        this.hallRepository = hallRepository;
        this.fitnessCenterService = fitnessCenterService;
    }

    @Override
    public List<Hall> findAll() {
        return hallRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        hallRepository.deleteById(id);
    }

    @Override
    public Hall addHall(Hall hall) {
        return hallRepository.save(hall);
    }

    @Override
    public Hall addHall2(HallDTO hallDTO) {
        Hall hall = new Hall();
        hall.setCapacity(hallDTO.getCapacity());
        hall.setNumberOfHall(hallDTO.getNumberOfHall());

        FitnessCenter fitnessCenter = fitnessCenterService.findOneById(hallDTO.getFitnessCenterId());

        hall.setFitnessCenter(fitnessCenter);
        hallRepository.save(hall);
        return hall;
    }

    @Override
    public Optional<Hall> findOne(Long id) {
        return hallRepository.findById(id);
    }

    @Override
    public Hall updateHall(Hall hall) {
        return hallRepository.save(hall);
    }
}
