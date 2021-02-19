package it.fabrick.demo.dto;

import java.util.ArrayList;

public class ResponseAccount {
	
	
	private String status;
	private ArrayList<String> error;
	private AccountDto payload;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ArrayList<String> getError() {
		return error;
	}
	public void setError(ArrayList<String> error) {
		this.error = error;
	}
	public AccountDto getPayload() {
		return payload;
	}
	public void setPayload(AccountDto payload) {
		this.payload = payload;
	}


}
