package com.example.demo.dateservice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DateService 
{
	public ResponseEntity<?> service(String param1, String param2) throws Exception;
}
