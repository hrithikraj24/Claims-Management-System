package com.cts.claim.pojo;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ClaimInput {
	
	public String policyBenefits;
	public String hospitalName;
	public Integer benefitsAvailed;
	public Integer amount;
	public Integer policyId;
	public String policyName;

}
