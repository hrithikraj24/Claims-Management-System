package com.cts.claim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.claim.client.AuthClient;
import com.cts.claim.client.PolicyServiceClient;
import com.cts.claim.entity.Claim;
import com.cts.claim.pojo.ClaimInput;
import com.cts.claim.pojo.PolicyProvider;
import com.cts.claim.exception.ClaimNotFoundException;
import com.cts.claim.exception.PolicyNotFoundException;
import com.cts.claim.repository.ClaimRepository;



@Service
public class ClaimService {
	@Autowired
	ClaimRepository claimrepo;
	@Autowired
	AuthClient authClient;
	@Autowired
	PolicyServiceClient policyclient;
	public Claim getClaimStatus(Integer claimId) throws ClaimNotFoundException {
		Claim claim = claimrepo.findById(claimId).orElse(null);
		if(claim==null)
			throw new ClaimNotFoundException("Claim not found");
		else
			return claim;
	}
	public Claim submitClaim(ClaimInput claimInput) throws PolicyNotFoundException {
		int claimAmount = policyclient.getEligibleClaimAmount(claimInput.getPolicyId());
		List<PolicyProvider> list = policyclient.getAllPolicyProviders(claimInput.getPolicyId());
		boolean flag=false;
		for(PolicyProvider p:list) {
			if(p.getHospitalName().equalsIgnoreCase(claimInput.getHospitalName())) {
				flag=true;
				break;
			}
		}
		Claim claim=new Claim();
		claim.setAmount(claimInput.getAmount());
		claim.setBenefitsAvailed(claimInput.getBenefitsAvailed());
		claim.setHospitalName(claimInput.getHospitalName());
		claim.setPolicyBenefits(claimInput.getPolicyBenefits());
		claim.setPolicyId(claimInput.getPolicyId());
		claim.setPolicyName(claimInput.getPolicyName());		
		if(flag==true && claimAmount>=claimInput.getAmount()) {
			claim.setStatus("Sanctioned");
			claim.setRemarks("Please contact the branch office.");
		}
		else {
			claim.setStatus("Rejected");
			claim.setRemarks("Please check your eligibilty criteria");
		}
		claim=claimrepo.save(claim);
		return claim;		
	}

}
