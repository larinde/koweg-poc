/**
 * 
 */
package com.koweg.poc.payments.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.koweg.poc.payments.misc.akka.InsufficientFundsException;
import com.koweg.poc.payments.rest.representation.MoneyTransfer;

/**
 * @author olarinde.ajai@gmail.com
 * 
 */
public class AccountServiceImpl implements AccountService {
  private static Map<String, BigDecimal> accounts = new HashMap<String, BigDecimal>();
  private String responseMessage = "Successfully transferred ";

  static {
    accounts.put("Olarinde Ajai", new BigDecimal("300700.25"));
    accounts.put("Koweg Software Solutions Limited", new BigDecimal("700333777111.73"));
    accounts.put("ING-Diba-8004047915", new BigDecimal("30000.70"));
  }

  public void depositTo(MoneyTransfer moneyTransfer) throws InsufficientFundsException {
    BigDecimal newBalance = accounts.get(moneyTransfer.getRecipient()).add(moneyTransfer.getAmount());
    accounts.put(moneyTransfer.getRecipient(), newBalance);
    System.out.println("----------------------- MAIN SERVER ---------------------------------");
    System.out.format("Current Balance - %s = €%f ", moneyTransfer.getRecipient(), newBalance);
    System.out.format("\nCurrent Balance - %s = €%f \n", moneyTransfer.getSender(),
        accounts.get(moneyTransfer.getSender()));
  }

  public void withdrawFrom(MoneyTransfer moneyTransfer) throws InsufficientFundsException {
    if (accounts.get(moneyTransfer.getSender()).subtract(moneyTransfer.getAmount()).compareTo(BigDecimal.ONE) <= 0) {
      throw new InsufficientFundsException();
    } else {
      accounts.put(moneyTransfer.getSender(),
          accounts.get(moneyTransfer.getSender()).subtract(moneyTransfer.getAmount()));
    }
  }

  @Override
  public boolean isAvailable() {
    return true;
  }


}
