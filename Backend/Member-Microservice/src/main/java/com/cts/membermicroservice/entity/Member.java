package com.cts.membermicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="Member")
public class Member {
	@Id
	private String memberId;
	private String memberName;
	private Integer phoneNo;
	private String address;

}
