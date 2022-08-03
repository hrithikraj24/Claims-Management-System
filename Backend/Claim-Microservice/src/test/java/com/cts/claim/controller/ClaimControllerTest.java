package com.cts.claim.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.claim.pojo.ClaimInput;
import com.cts.claim.service.ClaimService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc	
class ClaimControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;
	@MockBean
	ClaimService service;
	
	@Test
	void notNull() {
		assertThat(service).isNotNull();
	}
	@Test
	void notNull1() {
		assertThat(mockMvc).isNotNull();
	}


	

	@Test
	void testGetClaimStatus() throws Exception {
		this.mockMvc.perform(get("/getclaimstatus/{claimId}", 10)).andExpect(status().isOk());

	}

	@Test
	void testSubmitClaim() throws Exception {
		ClaimInput claim1= new ClaimInput();
		claim1.amount= 8000;
		claim1.benefitsAvailed= 10000;
		claim1.hospitalName="Apollo";
		claim1.policyBenefits="Dialysis";
		claim1.policyId=2000;
		claim1.policyName="Policy-Bazar";
		//Claim claim= service.submitClaim(claim1);
		//when(service.submitClaim(claim1)).thenReturn(claim);
		String jsonString = mapper.writeValueAsString(claim1);
		this.mockMvc.perform(post("/submitclaim").contentType(MediaType.APPLICATION_JSON)
				.content(jsonString)).andExpect(status().isOk());
	}

}