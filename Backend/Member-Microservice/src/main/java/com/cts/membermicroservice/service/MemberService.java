package com.cts.membermicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.membermicroservice.client.AuthClient;
import com.cts.membermicroservice.client.ClaimClient;
import com.cts.membermicroservice.entity.MemberPremium;
import com.cts.membermicroservice.exception.ClaimNotFoundException;
import com.cts.membermicroservice.exception.MemberNotFoundException;
import com.cts.membermicroservice.exception.PolicyNotFoundException;
import com.cts.membermicroservice.exception.TokenExpireException;
import com.cts.membermicroservice.pojo.Claim;
import com.cts.membermicroservice.pojo.ClaimInput;
import com.cts.membermicroservice.repository.MemberPremiumRepository;

@Service
public class MemberService {
	@Autowired
	MemberPremiumRepository memberRepo;
	@Autowired
	ClaimClient claimClient;
	@Autowired
	AuthClient authClient;
	public MemberPremium viewBills(String memberId, String token) throws MemberNotFoundException, TokenExpireException {
		if(authClient.authorizeTheRequest(token)) {
		MemberPremium member = memberRepo.findById(memberId).orElse(null);
		if(member==null) {
			throw new MemberNotFoundException("Member not found");
		}
		else {
			return member;
		}
		}
		else {
			throw new TokenExpireException("Token is expired");
		}
	}
	
	public Claim getClaimStatus(Integer claimId) throws ClaimNotFoundException {
		Claim claim = claimClient.getClaimStatus(claimId);
		if(claim==null)
			throw new ClaimNotFoundException("Claim not found");
		else
			return claim;
	}
	public Claim submitClaim(ClaimInput claimInput) throws PolicyNotFoundException {
		Claim claim=claimClient.submitClaim(claimInput);
		return claim;
	}
	
	

}
