package com.cts.policy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="POLICYPROVIDER")
@Setter
@Getter
@ToString
public class PolicyProvider {
	@Id
	 private Integer providerId;
	 private String hospitalName;
	 private String location;
	 private int policyId;

}
