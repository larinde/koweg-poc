package com.koweg.poc.ingestion.model.converter;


import java.math.BigDecimal;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class BigDecimalConverter extends AbstractBeanField<BigDecimal>{

  @Override
  protected BigDecimal convert(String data) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
    if (data.equalsIgnoreCase("null")) {
      return BigDecimal.valueOf(0);
    }
    return new BigDecimal(data);
  }

}
