package it.fabrick.demo.exceptions.errors;

import io.swagger.annotations.ApiModel;

@ApiModel(value= "ErrorResponse", description="ErrorResponse model")
public class ErrorRepsonse {
	
	private String code;
	private String description;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
