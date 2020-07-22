package com.example.demo.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.dto.CommonRequest;
import com.example.demo.powerservice.PowerService;

@Service
public class Manager
{
	@Autowired
	private PowerService ser;
	
	public ResponseEntity<?> operation(CommonRequest req) 
	{
		return ser.service(req.getParam1(), req.getParam2());
	}
	

}
