package com.classproject.FitnessCenter.controller;

import com.classproject.FitnessCenter.entity.Member;
import com.classproject.FitnessCenter.entity.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TrainerController {
    /* Metoda za registraciju novog clana fitnes centra */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDTO> createMember(@RequestBody MemberDTO memberDTO) throws Exception {
        Member member = new Member(memberDTO.getId(), memberDTO.getFirstName(), memberDTO.getLastName(), memberDTO.getUsername(),
                memberDTO.getPassword(), memberDTO.getContact(), memberDTO.getEmail(), memberDTO.getBirthDate(),
                memberDTO.getTypeOfUser());

        Member newMember = memberService.create(member);

        MemberDTO newMemberDTO = new MemberDTO(newMember.getId(), newMember.getFirstName(), newMember.getLastName(),
                newMember.getEmail(), newMember.getUsername(), newMember.getPassword(), newMember.getContact(), newMember.getTypeOfUser(),
                newMember.getBirthDate());

        return new ResponseEntity<>(newMemberDTO, HttpStatus.CREATED);
    }
}
