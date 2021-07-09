package com.classproject.FitnessCenter.repository;

import com.classproject.FitnessCenter.entity.Terms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TermsRepository extends JpaRepository<Terms, Long> {

    List<Terms> findByPrice(Double price);
    List<Terms> findByTrainingDay(Date trainingDay);
    Terms findOneById(Long id);
}
