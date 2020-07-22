package com.example.demo.powerserviceimpl;

import org.apache.commons.math3.util.Precision;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CommonResponse;
import com.example.demo.powerservice.PowerService;

@Component
public class PowerServiceImpl implements PowerService 
{

	@Override
	public ResponseEntity<?> service(String param1, String param2) 
	{
		Double power = Math.pow(Double.parseDouble(param1), Double.parseDouble(param2));
		CommonResponse response = new CommonResponse();
		response.setResponse(Precision.round(power.doubleValue(), 2));
		return ResponseEntity.ok(response);
	}

}
