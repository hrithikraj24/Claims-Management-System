package com.cts.claim.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.claim.pojo.PolicyProvider;
import com.cts.claim.exception.PolicyNotFoundException;



@FeignClient(url="${policy.url}",name="policyapp")
public interface PolicyServiceClient {
	@GetMapping(value="/geteligibleclaimamount/{policyId}")
	public Integer getEligibleClaimAmount(@PathVariable("policyId") Integer policyId) throws PolicyNotFoundException;
	
	@GetMapping(value="/getallproviders/{policyId}")
	public List<PolicyProvider> getAllPolicyProviders(@PathVariable("policyId")Integer policyId);

}
