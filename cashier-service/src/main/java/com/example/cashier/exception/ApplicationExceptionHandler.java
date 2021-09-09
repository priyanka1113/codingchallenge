package com.example.cashier.exception;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

	
  
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ApiException> handleGenericException(Exception e){
		ApiException apiException = new ApiException(100, "Data not Found");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(apiException);
    }

	 @ExceptionHandler(ResourceNotFoundException.class)
	  public ResponseEntity<ApiException> resourceNotFoundException(ResourceNotFoundException ex) {
	    
	    ApiException apiException = new ApiException(101, ex.getMessage());
	    return  ResponseEntity.status(HttpStatus.NOT_FOUND)
	    		.body(apiException);
	  }

}
