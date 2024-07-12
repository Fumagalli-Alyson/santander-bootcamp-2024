package me.dio.domain.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> lidar(IllegalArgumentException businessException) {
		return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> lidar(NoSuchElementException notFoundException) {
		return new ResponseEntity<>("Resource ID not found.", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> lidar(Throwable unexpectedException) {
		String mensagem = "Unexpected server error, see the logs.";
		logger.error(mensagem, unexpectedException);
		return new ResponseEntity<>(mensagem, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}