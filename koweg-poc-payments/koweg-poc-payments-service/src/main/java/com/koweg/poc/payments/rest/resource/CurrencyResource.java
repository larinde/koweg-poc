package com.koweg.poc.payments.rest.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koweg.poc.payments.rest.representation.ExchangeRate;


public interface CurrencyResource {

    ExchangeRate getExchangeRate(String fromCurr, String toCurr);

}