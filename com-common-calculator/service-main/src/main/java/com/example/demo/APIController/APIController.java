package com.example.demo.APIController;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.common.dto.CommonRequest;
import com.common.exception.service.InputNotValid;
import com.example.demo.APIServices.APIService;

@RestController
public class APIController {
		
	@Autowired
	private APIService per;
	
	@RequestMapping(value = "/api", method = RequestMethod.POST)
	public ResponseEntity<?> expression(@Valid @RequestBody CommonRequest request) throws Exception
	{
			if(!request.getService().matches("^[a-z]{7}-[a-z]{5}$"))
			{
				throw new InputNotValid("Input Service is not valid");
			}
			return per.perform(request);
	}
}
