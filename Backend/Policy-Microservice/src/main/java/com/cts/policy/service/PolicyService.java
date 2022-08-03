package com.cts.policy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.policy.exception.PolicyNotFoundException;
import com.cts.policy.exception.TokenExpireException;
import com.cts.policy.repository.PolicyProviderRepository;
import com.cts.policy.repository.PolicyRepository;
import com.cts.policy.client.AuthClient;
import com.cts.policy.entity.ClientPolicy;
import com.cts.policy.entity.PolicyProvider;



@Service
public class PolicyService {
	@Autowired
	PolicyRepository policyrepo;
	@Autowired
	PolicyProviderRepository policyProviderRepository;
	@Autowired
	AuthClient authClient;
	public Integer getEligibleClaimAmount(Integer policyId) throws PolicyNotFoundException {
		ClientPolicy policy = policyrepo.findById(policyId).orElse(null);
		if(policy==null)
			throw new PolicyNotFoundException("Policy not found");
		else
			return policy.getTenure();
	}
	public String getEligibleBenefits(Integer policyId, String token) throws PolicyNotFoundException, TokenExpireException {
		if(authClient.authorizeTheRequest(token)) {
		ClientPolicy policy = policyrepo.findById(policyId).orElse(null);
		if(policy==null)
			throw new PolicyNotFoundException("Policy not found");
		else
			return policy.getPolicyBenefits();
		}
		else
		{
			throw new TokenExpireException("Token is expired");
		}
	}
	//PolicyProviderRepository policyProviderRepository;
	public List<PolicyProvider> getAllPolicyProviders(Integer policyId){
		List<PolicyProvider> list= policyProviderRepository.getAllPolicyProviders(policyId);
		return list;
		
	}

}
