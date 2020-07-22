package com.common.dto;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CommonRequest 
{
	@NotEmpty
	private String service;
	
	@NotEmpty
	private String param1;
	
	@NotEmpty
	private String param2;
}
