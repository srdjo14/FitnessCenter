package com.classproject.FitnessCenter.Service;

import com.classproject.FitnessCenter.entity.Terms;
import com.classproject.FitnessCenter.entity.dto.TermsAddDTO;
import com.classproject.FitnessCenter.entity.dto.TermsDTO;

import java.util.List;
import java.util.Optional;

public interface TermsService {

    List<Terms> findAll();
    Terms addTerms(Terms terms);

    Terms findOneById(Long id);

    Optional<Terms> findOne(Long id);

    Terms updateTerms(Terms terms);
}
