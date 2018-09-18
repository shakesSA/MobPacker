package com.mobiquityinc.exceptions;
/**
* The class defines the Custom Exception for the API
*  @author Shakes
*/

public class APIException extends Exception {

	private static final long serialVersionUID = -6851849845097090007L;

	public APIException() {
	}

	public APIException(String arg0) {
		super(arg0);
	}

	public APIException(Throwable arg0) {
		super(arg0);
	}

	public APIException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public APIException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
