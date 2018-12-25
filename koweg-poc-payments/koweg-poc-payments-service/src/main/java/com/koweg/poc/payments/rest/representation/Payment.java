/**
 *
 */
package com.koweg.poc.payments.rest.representation;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public class Payment extends AbstractTransfer {
    private Long id;
    // @TransferAmount
    private BigDecimal amount;
//    @JsonSerialize(using = JsonDateSerializer.class)
    private Date date;
    @JsonProperty("currency")
    @NotNull
    private String curr;

    public Payment() {
        super();
    }

    public Payment(Long id, BigDecimal amount, Date date, String curr) {
        super();
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.curr = curr;
    }

    public Long getId() {
        return id;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getCurr() {
        return curr;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

}
