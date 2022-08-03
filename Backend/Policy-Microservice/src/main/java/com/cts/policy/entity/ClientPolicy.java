package com.cts.policy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="Policy")
public class ClientPolicy {
	
	@Id
	private Integer policyNo;
	private String policyName;
	private String policyBenefits;
	private Integer tenure;
	private Integer premium;
	
}
