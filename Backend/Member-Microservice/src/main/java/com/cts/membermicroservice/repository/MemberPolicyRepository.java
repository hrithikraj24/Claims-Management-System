package com.cts.membermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.membermicroservice.entity.MemberPolicy;



@Repository

public interface MemberPolicyRepository extends JpaRepository<MemberPolicy, String> {

}
