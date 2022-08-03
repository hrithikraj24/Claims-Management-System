package com.cts.policy.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ErrorResponse{
	private Integer statusCode;
	private String statusMsg;
	private LocalDateTime statusDate;
}