package com.example.demo.powercontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommonRequest;
import com.example.demo.manager.Manager;

@RestController
public class PowerController
{
	@Autowired
	private Manager power;
	
	@RequestMapping(value = "/power", method = RequestMethod.POST)
	public ResponseEntity<?> math(@Valid @RequestBody CommonRequest req)
	{
		return power.operation(req);
	}
}
