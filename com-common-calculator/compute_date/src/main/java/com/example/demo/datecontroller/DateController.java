package com.example.demo.datecontroller;

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
public class DateController
{
	@Autowired
	private Manager date;
	
	@RequestMapping(value = "/date", method = RequestMethod.POST)
	public ResponseEntity<?> math(@Valid @RequestBody CommonRequest req) throws Exception
	{
		return date.operation(req);
	}
}
