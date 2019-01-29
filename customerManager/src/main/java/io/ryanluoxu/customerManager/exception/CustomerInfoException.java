package io.ryanluoxu.customerManager.exception;

public class CustomerInfoException extends Exception {

	private static final long serialVersionUID = -4839297392387027659L;
	
	private String errorMsg;

	public CustomerInfoException(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
