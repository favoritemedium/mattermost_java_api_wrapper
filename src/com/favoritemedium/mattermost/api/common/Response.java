package com.favoritemedium.mattermost.api.common;

public class Response {
	
	private long receivedAt = System.currentTimeMillis();
	private int responseCode;
	private String data;
	private boolean isError;
	private String errorMessage;
	private int errorCode;
	
	public Response() {
		
	}
	
	public Response(int errorCode, String errorMessage) {
		this.isError = true;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public long getReceivedAt() {
		return receivedAt;
	}
	public void setReceivedAt(long receivedAt) {
		this.receivedAt = receivedAt;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
