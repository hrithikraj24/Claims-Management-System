package com.cts.claim.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="Claim")
public class Claim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer claimNo;
	private String status;
	private String remarks;
	private String policyBenefits;
	private String hospitalName;
	private Integer benefitsAvailed;
	private Integer amount;
	private Integer policyId;
	private String policyName;

}
