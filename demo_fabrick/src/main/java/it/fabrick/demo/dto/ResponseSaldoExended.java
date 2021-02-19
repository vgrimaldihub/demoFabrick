package it.fabrick.demo.dto;

import java.util.ArrayList;

public class ResponseSaldoExended {
	
	private String status;
	private ArrayList<String> error;
	private ResponseSaldo payload;
	
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
	public ResponseSaldo getPayload() {
		return payload;
	}
	public void setPayload(ResponseSaldo payload) {
		this.payload = payload;
	}

}
