package com.cts.policy.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import com.cts.policy.client.AuthClient;
import com.cts.policy.service.PolicyService;

@SpringBootTest
@AutoConfigureMockMvc
class PolicyControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	PolicyService service;
	@MockBean
	AuthClient authClient;
	
	@Test
	void notNull() {
		assertThat(service).isNotNull();
	}
	@Test
	void notNull1() {
		assertThat(mockMvc).isNotNull();
	}


	@Test
	void testGetEligibleClaimAmount() throws Exception {
		this.mockMvc.perform(get("/geteligibleclaimamount/{policyId}", 1000)).andExpect(status().isOk());
	}
	@Test
	void testGetEligiblebenefitswithvalidToken() throws Exception {
		when(authClient.authorizeTheRequest("@uthoriz@tionToken123")).thenReturn(true);
		this.mockMvc.perform(get("/geteligiblebenefits/{policyId}", 1000).header("Authorization", "@uthoriz@tionToken123")).andExpect(status().isOk());
	}

	

	@Test
	void testgetAllPolicyProviders() throws Exception {
		this.mockMvc.perform(get("/getallproviders/{policyId}", 1000)).andExpect(status().isOk());
	}

}
