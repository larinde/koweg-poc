package com.koweg.poc.ingestion.model.converter;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class CsvDateConverter extends AbstractBeanField<LocalDate> {

  @Override
  protected LocalDate convert(String dateAsString) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
    return LocalDate.parse(dateAsString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }

}
