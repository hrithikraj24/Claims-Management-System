package com.cts.claim.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.claim.client.AuthClient;
import com.cts.claim.client.PolicyServiceClient;
import com.cts.claim.entity.Claim;
import com.cts.claim.exception.ClaimNotFoundException;
import com.cts.claim.exception.PolicyNotFoundException;
import com.cts.claim.pojo.ClaimInput;
import com.cts.claim.pojo.PolicyProvider;
import com.cts.claim.repository.ClaimRepository;



class ClaimServiceTest {
	@Mock
	AuthClient authClient;
	@Mock
	PolicyServiceClient policyclient;
	@Mock
	ClaimRepository claimrepo;
	@InjectMocks
	ClaimService service;
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetClaimStatus() throws ClaimNotFoundException {
		Claim claim1= new Claim(10, "Sanctioned", "NIL", "Cancer", "Apollo", 100000, 70000, 1000, "Jeevan");
		when(claimrepo.save(claim1)).thenReturn(claim1);
		when(claimrepo.findById(10)).thenReturn(Optional.of(claim1));
		assertTrue(service.getClaimStatus(10).equals(claim1));
	}
	@Test
	void testGetClaimStatusWithInvalidId() throws ClaimNotFoundException {
		Claim claim1= new Claim(10, "Sanctioned", "NIL", "Cancer", "Apollo", 100000, 70000, 1000, "Jeevan");
		when(claimrepo.save(claim1)).thenReturn(claim1);
		when(claimrepo.findById(10)).thenReturn(Optional.of(claim1));
		assertThrows(ClaimNotFoundException.class, () -> {
			service.getClaimStatus(20); //Claim Not Found Exception
		});
	}


	@Test
	void testSubmitClaim() throws PolicyNotFoundException {
		ClaimInput claim1= new ClaimInput();
		claim1.amount= 8000;
		claim1.benefitsAvailed= 10000;
		claim1.hospitalName="Apollo";
		claim1.policyBenefits="Dialysis";
		claim1.policyId=2000;
		claim1.policyName="Policy-Bazar";
		when(claimrepo.save(claim1)).thenReturn(claim1);
		Claim claim= service.submitClaim(claim1);
		when(claimrepo.save(claim)).thenReturn(claim);
		when(service.submitClaim(claim1)).thenReturn(claim);
		assertThat(service.submitClaim(claim1)).isEqualTo(claim);
		}
}

