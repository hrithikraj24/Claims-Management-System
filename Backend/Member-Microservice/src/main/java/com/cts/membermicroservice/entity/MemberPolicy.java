package com.cts.membermicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table (name="MemberPolicy")
public class MemberPolicy {
	@Id
	private String memberId;
	private Integer policyId;
	

}
