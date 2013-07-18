package com.fanaifan.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * 自定义异常
 * @author zp
 */
public class MyException extends WebApplicationException {

	private static final long serialVersionUID = 1L;

	public MyException(ErrorBean error) {
		super(Response.serverError().entity(error).status(200).build());
	}
	
	public static void error(ErrorBean eb){
		throw new MyException(eb);
	}

	public static void error(String errorCode) {
		ErrorBean errorBean = new ErrorBean();
		errorBean.setErrorCode(errorCode);
		String errorValue = ErrorUtil.readValue(errorCode);
		errorBean.setError(errorValue);
		throw new MyException(errorBean);
	}

	public static void error(String errorCode, String request) {
		ErrorBean errorBean = new ErrorBean();
		errorBean.setErrorCode(errorCode);
		String errorValue = ErrorUtil.readValue(errorCode);
		errorBean.setError(errorValue);
		throw new MyException(errorBean);
	}


}