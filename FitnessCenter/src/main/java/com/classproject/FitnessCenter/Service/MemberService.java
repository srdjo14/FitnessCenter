package com.classproject.FitnessCenter.Service;

import com.classproject.FitnessCenter.entity.Member;

public interface MemberService {

    Member create(Member member) throws Exception;
    Boolean checkUsername(Member member) throws Exception;

    Member findOneById(Long id);
}
