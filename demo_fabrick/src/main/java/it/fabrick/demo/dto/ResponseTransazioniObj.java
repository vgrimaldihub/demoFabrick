package it.fabrick.demo.dto;

import java.util.ArrayList;


public class ResponseTransazioniObj {
	
	
	private String status;
	private ArrayList<String> error;
	private Payload payload;
	
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
	public Payload getPayload() {
		return payload;
	}
	public void setPayload(Payload payload) {
		this.payload = payload;
	}
	

	
}