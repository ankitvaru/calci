package com.common.exception.service;

public class BaseException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2674123745719075817L;

	public BaseException()
	{
		super();
	}
	
	public BaseException(String errormsg)
	{
		super(errormsg);
	}
}
