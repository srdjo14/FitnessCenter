package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/member")
public class MemberController {
    private final MemberService memberService;

    /* Constructor-based dependency injection */
    @Autowired
    public MemberController(MemberService memberService) {this.memberService = memberService; }

}
