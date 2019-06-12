package com.koweg.poc.ingestion.model.converter;


import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class IntegerConverter extends AbstractBeanField<Integer> {

  @Override
  protected Object convert(String data) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
    if (data.equalsIgnoreCase("null")) {
      return Integer.valueOf(0);
    }
    return Integer.valueOf(data);
  }

}
