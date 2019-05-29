/**
 * 
 */
package com.koweg.poc.payments.rest.representation;

import java.math.BigDecimal;

/**
 * @author olarinde.ajai@gmail.com
 * 
 */
public class PaymentRequest {

	private BigDecimal amount;
	private String currency;

	private PaymentRequest(BigDecimal amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
