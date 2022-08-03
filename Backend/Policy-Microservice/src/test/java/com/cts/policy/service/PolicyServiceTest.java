package com.cts.policy.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.cts.policy.client.AuthClient;
import com.cts.policy.entity.ClientPolicy;
import com.cts.policy.entity.PolicyProvider;
import com.cts.policy.exception.PolicyNotFoundException;
import com.cts.policy.exception.TokenExpireException;
import com.cts.policy.repository.PolicyProviderRepository;
import com.cts.policy.repository.PolicyRepository;

class PolicyServiceTest {
	
	@Mock
	PolicyRepository policyrepo;
	@Mock
	PolicyProviderRepository policyProviderRepository;
	@Mock
	AuthClient authClient;
	@InjectMocks
	PolicyService service;
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	private PolicyProvider policyprovider1;
	private PolicyProvider policyprovider2;
	@SuppressWarnings("unused")
	private PolicyProvider policyprovider3;
	private ClientPolicy policy1;
	@BeforeEach
	public void setup() {
		policy1= new ClientPolicy(1000, "Jeevan", "Cancer", 1000000, 10000);
		policyprovider1= new PolicyProvider(1, "apollo", "hyd", 1000);
		policyprovider2= new PolicyProvider(2, "Iris", "hyd", 1000);
		policyprovider3= new PolicyProvider(3, "Narayana", "hyd", 2000);
		
	}
	



	@Test
	@DisplayName("Test PolicyRepository mock")
	public void policyrepoNotNullTest() {
		assertThat(policyrepo).isNotNull();
	}
	@Test
	@DisplayName("Test PolicyProviderRepository mock")
	void policyProviderRepositoryNotNullTest() {
		assertThat(policyProviderRepository).isNotNull();
	}
	@Test
	void GetEligibleClaimAmountTest() throws PolicyNotFoundException {
		//ClientPolicy policy1= new ClientPolicy(1000, "Jeevan", "Cancer", 1000000, 10000);
		when(policyrepo.save(policy1)).thenReturn(policy1);
		when(policyrepo.findById(1000)).thenReturn(Optional.of(policy1));
		assertTrue(service.getEligibleClaimAmount(1000).equals(1000000));
	}

	@Test
	void GetEligibleBenefitsTest() throws PolicyNotFoundException, TokenExpireException {
		when(authClient.authorizeTheRequest("@uthoriz@tionToken123")).thenReturn(true);
		//ClientPolicy policy1= new ClientPolicy(1000, "Jeevan", "Cancer", 1000000, 10000);
		when(policyrepo.save(policy1)).thenReturn(policy1);
		when(policyrepo.findById(1000)).thenReturn(Optional.of(policy1));
		assertTrue(service.getEligibleBenefits(1000, "@uthoriz@tionToken123").equals("Cancer"));
	}
	@Test
	void GetInvalidTokenFindEligibleBenefitsTest() throws PolicyNotFoundException, TokenExpireException {
		when(authClient.authorizeTheRequest("@uthoriz@tionToken123")).thenReturn(true);
		//ClientPolicy policy1= new ClientPolicy(1000, "Jeevan", "Cancer", 1000000, 10000);
		when(policyrepo.save(policy1)).thenReturn(policy1);
		when(policyrepo.findById(1000)).thenReturn(Optional.of(policy1));
		assertThrows(TokenExpireException.class, () -> {service.getEligibleBenefits(1000, "WrongToken");});
	}
	@Test
	void GetInvalidIdFindEligibleBenefitsTest() throws PolicyNotFoundException, TokenExpireException {
		when(authClient.authorizeTheRequest("@uthoriz@tionToken123")).thenReturn(true);
		//ClientPolicy policy1= new ClientPolicy(1000, "Jeevan", "Cancer", 1000000, 10000);
		when(policyrepo.save(policy1)).thenReturn(policy1);
		when(policyrepo.findById(1000)).thenReturn(Optional.of(policy1));
		assertThrows(PolicyNotFoundException.class, () -> {service.getEligibleBenefits(4000, "@uthoriz@tionToken123");
		});
	}
	
	
	@Test
	void GetAllPolicyProviders() throws Exception {
		//PolicyProvider policyprovider1= new PolicyProvider(1, "apollo", "hyd", 1000);
		//PolicyProvider policyprovider2= new PolicyProvider(2, "Iris", "hyd", 1000);
		//PolicyProvider policyprovider3= new PolicyProvider(3, "Narayana", "hyd", 2000);
		//when(policyProviderRepository.save(policyprovider1)).thenReturn(policyprovider1);
		//when(policyProviderRepository.save(policyprovider2)).thenReturn(policyprovider2);
		when(policyProviderRepository.getAllPolicyProviders(1000)).thenReturn(Arrays.asList(policyprovider1, policyprovider2));
		//when(policyProviderRepository.findById(1000)).thenReturn(Optional.of(policyprovider2));
		assertThat(service.getAllPolicyProviders(1000)).hasSize(2);
	}


}
