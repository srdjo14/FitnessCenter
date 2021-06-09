package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.TermsService;
import com.classproject.FitnessCenter.entity.Terms;
import com.classproject.FitnessCenter.repository.TermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermsServiceImpl implements TermsService {

    private final TermsRepository termsRepository;
    @Autowired
    public TermsServiceImpl(TermsRepository termsRepository) {
        this.termsRepository = termsRepository;
    }

    /* Dobavljanje svih termina */
    @Override
    public List<Terms> findAll() {
        List<Terms> terms = this.termsRepository.findAll();
        return terms;
    }
}
