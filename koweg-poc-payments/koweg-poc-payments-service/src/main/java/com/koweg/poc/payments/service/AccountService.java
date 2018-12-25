/**
 * 
 */
package com.koweg.poc.payments.service;

import java.math.BigDecimal;

import com.koweg.poc.payments.misc.akka.InsufficientFundsException;
import com.koweg.poc.payments.rest.representation.MoneyTransfer;


/**
 * @author olarinde.ajai@gmail.com
 * 
 */
public interface AccountService {

	public boolean isAvailable();

	public void depositTo(MoneyTransfer moneyTransfer) throws InsufficientFundsException;

	public void withdrawFrom(MoneyTransfer moneyTransfer) throws InsufficientFundsException;

}
