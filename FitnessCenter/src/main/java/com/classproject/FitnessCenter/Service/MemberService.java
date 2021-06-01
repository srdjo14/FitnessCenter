package com.classproject.FitnessCenter.Service;

import com.classproject.FitnessCenter.entity.Member;

public interface MemberService {

    Member findOne(Long id);
    Member create(Member member) throws Exception;
}
