package com.koweg.poc.payments.rest.exception;

public class PaymentNotFoundException extends Exception {

	private static final long serialVersionUID = 5254740650388612484L;

	private static final String ERROR_MESSAGE = "Payment %d does not exist";

	public PaymentNotFoundException(Long id) {
		super(String.format(ERROR_MESSAGE, id));
	}


}
