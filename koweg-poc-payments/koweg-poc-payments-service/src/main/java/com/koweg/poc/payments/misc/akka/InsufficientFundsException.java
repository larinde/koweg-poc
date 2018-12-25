/**
 * 
 */
package com.koweg.poc.payments.misc.akka;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public class InsufficientFundsException extends Exception {

	public InsufficientFundsException(String responseMessage) {
		super(responseMessage);
	}

	public InsufficientFundsException() {
	}

	private static final long serialVersionUID = -4477687859264896458L;

}
