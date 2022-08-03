package com.cts.claim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.claim.entity.Claim;
import com.cts.claim.exception.ClaimNotFoundException;
import com.cts.claim.exception.PolicyNotFoundException;
import com.cts.claim.pojo.ClaimInput;
import com.cts.claim.service.ClaimService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClaimController {
	@Autowired
	ClaimService service;
	@GetMapping(value="/getclaimstatus/{claimId}")
	public Claim getClaimStatus(@PathVariable("claimId") Integer claimId) throws ClaimNotFoundException {
		return service.getClaimStatus(claimId);
	}
	
	@PostMapping(value="/submitclaim")
	public Claim submitClaim(@RequestBody ClaimInput claim) throws PolicyNotFoundException {
		return service.submitClaim(claim);
	}

}
