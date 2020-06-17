package edu.miu.cs544.exception;


import edu.miu.cs544.service.response.ExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
public class ControllerAdviceExceptionHandler extends ResponseEntityExceptionHandler {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<ExceptionResponse> handleResponseStatusException(ResponseStatusException ex) {
		logger.info("Start of ResponseStatusException");
		String message = ex.getReason();
		Integer errorCode=  Integer.parseInt(ex.getStatus().toString().substring(0, 3));
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), errorCode, ex.getStatus().name(), message);
		logger.info("End of ResponseStatusException");
		return new ResponseEntity<>(exceptionResponse, ex.getStatus());
	}
}