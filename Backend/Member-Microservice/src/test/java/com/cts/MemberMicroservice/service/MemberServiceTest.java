package com.cts.MemberMicroservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.membermicroservice.client.ClaimClient;
import com.cts.membermicroservice.entity.MemberPremium;
import com.cts.membermicroservice.exception.ClaimNotFoundException;
import com.cts.membermicroservice.exception.MemberNotFoundException;
import com.cts.membermicroservice.exception.PolicyNotFoundException;
import com.cts.membermicroservice.exception.TokenExpireException;
import com.cts.membermicroservice.pojo.Claim;
import com.cts.membermicroservice.pojo.ClaimInput;
import com.cts.membermicroservice.repository.MemberPremiumRepository;
import com.cts.membermicroservice.service.MemberService;
import com.cts.membermicroservice.client.AuthClient;

class MemberServiceTest {
	
	@Mock
	MemberPremiumRepository memberRepo;

	@Mock
	ClaimClient claimClient;
	@Mock
	AuthClient authClient;
	@InjectMocks
	MemberService service;
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testViewBills() throws MemberNotFoundException, TokenExpireException {
		MemberPremium member1= new MemberPremium();
		when(authClient.authorizeTheRequest("@uthoriz@tionToken123")).thenReturn(true);
		when(memberRepo.save(member1)).thenReturn(member1);
		when(memberRepo.findById("admin")).thenReturn(Optional.of(member1));
		assertTrue(service.viewBills("admin","@uthoriz@tionToken123").equals(member1));
		
	}
	@Test
	void testViewBillsMemberNotFonund() throws MemberNotFoundException, TokenExpireException {
		MemberPremium member1= new MemberPremium();
		when(authClient.authorizeTheRequest("@uthoriz@tionToken123")).thenReturn(true);
		when(memberRepo.save(member1)).thenReturn(member1);
		when(memberRepo.findById("admin")).thenReturn(Optional.of(member1));
		assertThrows(MemberNotFoundException.class, () -> {service.viewBills("admin2", "@uthoriz@tionToken123");
		});
		
	}
	@Test
	void testViewBillsTokenExpire() throws MemberNotFoundException, TokenExpireException {
		MemberPremium member1= new MemberPremium();
		when(authClient.authorizeTheRequest("@uthoriz@tionToken123")).thenReturn(true);
		when(memberRepo.save(member1)).thenReturn(member1);
		when(memberRepo.findById("admin")).thenReturn(Optional.of(member1));
		assertThrows(TokenExpireException.class, () -> {service.viewBills("admin", "WrongToken");
		});
		
	}

	//@Test
	//void testGetClaimStatus() throws ClaimNotFoundException {
		//Claim claim1= new Claim(10, "Sanctioned", "NIL", "Cancer", "Apollo", 100000, 70000, 1000, "Jeevan");
		//when(service.save(claim1)).thenReturn(claim1);
		//when(claimClient.getClaimStatus(10)).thenReturn(claim1);
		//assertTrue(service.getClaimStatus(10).equals(claim1));
	//}
	//@Test
	//void testGetClaimStatusWithInvalidId() throws ClaimNotFoundException {
		//Claim claim1= new Claim(10, "Sanctioned", "NIL", "Cancer", "Apollo", 100000, 70000, 1000, "Jeevan");
		//when(service.save(claim1)).thenReturn(claim1);
		//when(claimClient.getClaimStatus(10)).thenReturn(claim1);
		//assertThrows(ClaimNotFoundException.class, () -> {
			//service.getClaimStatus(20);
		//});
	//}

	//@Test
	//void testSubmitClaim() throws PolicyNotFoundException {
		//ClaimInput claim1= new ClaimInput("Dialysis", "Apollo", 10000, 8000, 2000,"Jeevan");
		//when(service.save(claim1)).thenReturn(Optional.of(claim1));
		//Claim claim2= claimClient.submitClaim(claim1);
		//when(service.submitClaim(claim1)).thenReturn(Optional.of(claim2));
		//assertTrue(service.submitClaim(claim1).equals(claim2));
		
	//}

}
