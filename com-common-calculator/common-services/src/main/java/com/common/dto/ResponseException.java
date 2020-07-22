package com.common.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseException implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6675278815152011267L;

	private String response = " ";
	
	private String responseCode = " ";
	
	private String responseDesc = " ";
}
