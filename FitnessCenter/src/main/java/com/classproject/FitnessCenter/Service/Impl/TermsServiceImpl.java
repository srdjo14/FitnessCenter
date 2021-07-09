package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.TermsService;
import com.classproject.FitnessCenter.Service.TrainingService;
import com.classproject.FitnessCenter.entity.Terms;
import com.classproject.FitnessCenter.entity.dto.TermsAddDTO;
import com.classproject.FitnessCenter.repository.TermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TermsServiceImpl implements TermsService {

    private final TermsRepository termsRepository;
    private final TrainingService trainingService;
    @Autowired
    public TermsServiceImpl(TermsRepository termsRepository, TrainingService trainingService) {
        this.termsRepository = termsRepository;
        this.trainingService = trainingService;
    }

    /* Dobavljanje svih termina */
    @Override
    public List<Terms> findAll() {
        List<Terms> terms = this.termsRepository.findAll();
        return terms;
    }

    @Override
    public Terms addTerms(Terms terms) {
        return this.termsRepository.save(terms);
    }

    @Override
    public Terms findOneById(Long id) {
        return this.termsRepository.findOneById(id);
    }

    @Override
    public Optional<Terms> findOne(Long id) {
        return termsRepository.findById(id);
    }

    @Override
    public Terms updateTerms(Terms terms) {
        return termsRepository.save(terms);
    }

}
