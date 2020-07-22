package com.example.demo.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dateservice.DateService;
import com.example.demo.dto.CommonRequest;

@Service
public class Manager 
{
	@Autowired
	private DateService ser;

	public ResponseEntity<?> operation(CommonRequest req) throws Exception 
	{
		return ser.service(req.getParam1(), req.getParam2());
	}

	
	
	
}
