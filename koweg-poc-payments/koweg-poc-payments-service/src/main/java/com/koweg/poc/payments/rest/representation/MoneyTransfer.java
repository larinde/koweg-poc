/**
 * 
 */
package com.koweg.poc.payments.rest.representation;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author olarinde.ajai@gmail.com
 * 
 */
public class MoneyTransfer implements Serializable{

	private final String sender;
	private final String recipient;
	private final BigDecimal amount;

	public MoneyTransfer(String sender, String recipient, BigDecimal amount) {
		super();
		this.sender = sender;
		this.recipient = recipient;
		this.amount = amount;
	}

	public String getSender() {
		return sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((recipient == null) ? 0 : recipient.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoneyTransfer other = (MoneyTransfer) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		return true;
	}

}
