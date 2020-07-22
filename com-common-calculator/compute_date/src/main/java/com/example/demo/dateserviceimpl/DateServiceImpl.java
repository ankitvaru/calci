package com.example.demo.dateserviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.math3.util.Precision;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.example.demo.dateservice.DateService;
import com.example.demo.dto.CommonResponse;

@Component
public class DateServiceImpl implements DateService 
{

	@Override
	public ResponseEntity<?> service(String param1, String param2) throws Exception 
	{
		Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(param1);
		Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(param2);
		
		long sub = d1.getTime() - d2.getTime();
		float day = sub/(1000*60*60*24);
		Double difference = (double)day;
		CommonResponse response = new CommonResponse();
		response.setResponse(Precision.round(difference.doubleValue(), 2));
		return ResponseEntity.ok(response);
	}

}
