package com.cts.policy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.policy.entity.PolicyProvider;

public interface PolicyProviderRepository extends JpaRepository<PolicyProvider, Integer>{
	@Query (value="select p from PolicyProvider p where p.policyId=:pid")
    public List<PolicyProvider> getAllPolicyProviders(@Param("pid") Integer pid);
	

}
