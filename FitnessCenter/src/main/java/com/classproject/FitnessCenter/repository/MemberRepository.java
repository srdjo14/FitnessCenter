package com.classproject.FitnessCenter.repository;

import com.classproject.FitnessCenter.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository <Member, Long> {

    Boolean existsByUsername(String username);
}
