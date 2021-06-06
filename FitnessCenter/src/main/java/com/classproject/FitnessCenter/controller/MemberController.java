package com.classproject.FitnessCenter.controller;


import com.classproject.FitnessCenter.Service.MemberService;
import com.classproject.FitnessCenter.entity.Member;
import com.classproject.FitnessCenter.entity.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/member")
public class MemberController {

    private MemberService memberService;

    /* Constructor-based dependency injection */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService; }

    /* Metoda za registraciju novog clana fitnes centra */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDTO> createMember(@RequestBody MemberDTO memberDTO) throws Exception {
        Member member = new Member(memberDTO.getFirstName(), memberDTO.getLastName(), memberDTO.getUsername(),
                memberDTO.getPassword(), memberDTO.getEmail(),  memberDTO.getContact(), memberDTO.getBirthDate(), memberDTO.getActive());

        Member newMember = memberService.create(member);

        MemberDTO newMemberDTO = new MemberDTO(newMember.getId(), newMember.getFirstName(), newMember.getLastName(),
                newMember.getUsername(), newMember.getPassword(),  newMember.getEmail(), newMember.getContact(), newMember.getBirthDate(), newMember.getActive());

        return new ResponseEntity<>(newMemberDTO, HttpStatus.CREATED);

    }
}


