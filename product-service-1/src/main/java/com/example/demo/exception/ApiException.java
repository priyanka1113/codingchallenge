package com.example.demo.exception;

public class ApiException {

	
	 private int errorCode;
	    private String message;

	   
	    public ApiException(int errorCode, String message) {
	        this.errorCode = errorCode;
	        this.message = message;
	    }

		public int getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	    
	    
}
