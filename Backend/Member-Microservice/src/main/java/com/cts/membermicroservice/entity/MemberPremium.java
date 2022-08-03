package com.cts.membermicroservice.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
//@AllArgsConstructor
@Setter
@Getter
@Table (name="MemberPremium")
public class MemberPremium {
	@Id
	private String memberId;
	private Integer premiumDue;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate lastPaidDate;
	private Integer policyId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dueDate;
	private String paymentDetails;
	

}
