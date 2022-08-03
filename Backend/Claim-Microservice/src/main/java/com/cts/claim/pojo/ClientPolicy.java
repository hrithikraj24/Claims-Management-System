package com.cts.claim.pojo;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter

public class ClientPolicy {
	
	private Integer policyNo;
	private String policyName;
	private String policyBenefits;
	private Integer tenure;
	private Integer premium;
	private String provider;
	
}
