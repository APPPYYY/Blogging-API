package com.esspl.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.esspl.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handledResourceNotFoundException(ResourceNotFoundException ex){
		String message=ex.getMessage();
		String author="__comeflywithme__";
		String solution=" If a id is not found on Postman, don't think they"
				+ " left the platform yet. See the other reasons behind it and ways to find the id";
		ApiResponse apiResponse=new ApiResponse(author,message,solution,false);
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> resp=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String key=((FieldError)error).getField();
			String value=error.getDefaultMessage();
			resp.put(key, value);
		});
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiResponse> handledApiException(ApiException ex){
		String message=ex.getMessage();
		String author="__comeflywithme__";
		String solution="Kindly check your username and password !!!";
		ApiResponse apiResponse=new ApiResponse(author,message,solution,false);
		return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
