package com.esspl.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String ResourceName;
	 String fieldName;
	 long fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s :%s",resourceName,fieldName,fieldValue));
		ResourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	 
}
