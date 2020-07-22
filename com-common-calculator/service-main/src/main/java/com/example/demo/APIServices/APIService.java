package com.example.demo.APIServices;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.common.dto.CommonRequest;
import com.common.dto.CommonResponse;
import com.common.exception.service.InputNotValid;
import com.example.demo.dto.ResponseDate;
import com.example.demo.dto.ResponsePower;

@Service
public class APIService {
	
	
	@Value("${url_date}")
	private String url_date;
	
	@Value("${url_power}")
	private String url_power;
	
	@Autowired
	private ResponseDate responseDate;
	
	@Autowired
	private ResponsePower responsePower;

	private CommonResponse res = new CommonResponse();

	String str1 = new String("compute-power");
	String str2 = new String("compute-dates");
	
	RestTemplate rest = new RestTemplate();

	public ResponseEntity<?> perform(@Valid CommonRequest request) throws Exception {
			if(request.getService().equals(str1))
			{
				if(!request.getParam1().matches("^[1-9]{2}.[1-9]{2}$") || !request.getParam2().matches("^[1-9]{2}.[1-9]{2}$")){
					throw new InputNotValid("Input Not Valid");
				}
				res = rest.postForObject(url_power, request, CommonResponse.class);
				responsePower.setPower(res.getResponse().toString());
				return ResponseEntity.ok(responsePower);
			}
			else
			{
				if(!request.getParam1().matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$") || !request.getParam2().matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$"))
				{
					throw new InputNotValid("Input Not Valid");
				}
				res = rest.postForObject(url_date, request, CommonResponse.class);
				responseDate.setDate(res.getResponse().toString());
				return ResponseEntity.ok(responseDate);
			}
		}
	}
	


