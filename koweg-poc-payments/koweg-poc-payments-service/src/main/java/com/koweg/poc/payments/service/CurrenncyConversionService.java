/**
 * 
 */
package com.koweg.poc.payments.service;

import java.math.BigDecimal;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public interface CurrenncyConversionService {

	public BigDecimal getExchangeRate(String fromCurr, String toCurr);

}
