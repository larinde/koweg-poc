/**
 * 
 */
package com.koweg.poc.payments.rest.representation;

import java.math.BigDecimal;

/**
 * @author olarinde.ajai@gmail.com
 * 
 */
public class ExchangeRate {

	private String fromCurr;
	private final String toCurr;
	private final BigDecimal rate;

	public ExchangeRate(final String fromCurr, final String toCurr, final BigDecimal rate) {
		this.fromCurr = fromCurr;
		this.toCurr = toCurr;
		this.rate = rate;
	}

	public String getFromCurr() {
		return fromCurr;
	}

	public void setFromCurr(String fromCurr) {
		this.fromCurr = fromCurr;
	}

	public String getToCurr() {
		return toCurr;
	}

	public BigDecimal getRate() {
		return rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromCurr == null) ? 0 : fromCurr.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((toCurr == null) ? 0 : toCurr.hashCode());
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
		ExchangeRate other = (ExchangeRate) obj;
		if (fromCurr == null) {
			if (other.fromCurr != null)
				return false;
		} else if (!fromCurr.equals(other.fromCurr))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (toCurr == null) {
			if (other.toCurr != null)
				return false;
		} else if (!toCurr.equals(other.toCurr))
			return false;
		return true;
	}

}
