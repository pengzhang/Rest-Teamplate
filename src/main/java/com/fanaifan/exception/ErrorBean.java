package com.fanaifan.exception;

/**
 *
 * @author zhangpeng
 *
 */
public class ErrorBean {

	public static String requestStr;
	private String request = requestStr;
	private String errorCode ;
	private String error ;

	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}





}
