package com.common.exception.service.handllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.common.dto.ResponseException;
import com.common.exception.service.InputNotValid;


@RestControllerAdvice
public class GlobalExceptionHandller extends ResponseEntityExceptionHandler
{
	
	ResponseException response = new ResponseException();
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders hth,
			HttpStatus hts, WebRequest wb)
	{
		response.setResponseCode("96");
		response.setResponseDesc(ex.getBindingResult().getFieldError().getField() + " "+
				ex.getBindingResult().getFieldError().getDefaultMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler({InputNotValid.class})
	public ResponseEntity<?> handleInputNotValid(InputNotValid ex, WebRequest wb)
	{
		response.setResponseCode("92");
		response.setResponseDesc(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
