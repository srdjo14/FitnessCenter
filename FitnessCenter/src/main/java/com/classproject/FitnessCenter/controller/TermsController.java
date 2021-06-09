package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.Service.TermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/terms")
public class TermsController {

    private final TermsService termsService;
    @Autowired
    public TermsController(TermsService termsService) {
        this.termsService = termsService;
    }

    /* Dobavljanje svih termina */
}
