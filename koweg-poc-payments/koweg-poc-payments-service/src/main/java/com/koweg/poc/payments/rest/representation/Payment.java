/**
 *
 */
package com.koweg.poc.payments.rest.representation;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Payment extends AbstractTransfer {
  private Long id;
  private BigDecimal amount;
  private Date date;
  @JsonProperty("currency")
  @NotNull
  private String curr;

  public Payment(Long id, BigDecimal amount, Date date, @NotNull String curr) {
    this.id = id;
    this.amount = amount;
    this.date = date;
    this.curr = curr;
  }



}
