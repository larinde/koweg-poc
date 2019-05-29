/**
 *
 */
package com.koweg.poc.payments.rest.resource;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koweg.poc.payments.rest.representation.ExchangeRate;
import com.koweg.poc.payments.service.CurrenncyConversionService;


/**
 * @author olarinde.ajai@gmail.com
 *
 */
@Controller
public class CurrencyResourceImpl implements CurrencyResource {

    private CurrenncyConversionService currenncyConversionService;

    @Override
    @RequestMapping(value = "/exchange/{fromCurr}/{toCurr}", method = RequestMethod.GET)
    public ExchangeRate getExchangeRate(String fromCurr, String toCurr) {
        BigDecimal rate = currenncyConversionService.getExchangeRate(fromCurr, toCurr);
        return new ExchangeRate(fromCurr, toCurr, rate);
    }
}
