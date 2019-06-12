package com.koweg.poc.ingestion.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.koweg.poc.ingestion.model.converter.CsvDateConverter;
import com.koweg.poc.ingestion.model.converter.BigDecimalConverter;
import com.koweg.poc.ingestion.model.converter.IntegerConverter;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class StockData {
  @CsvCustomBindByPosition(position=0, converter = CsvDateConverter.class)
  private LocalDate date;
  //  @CsvBindByPosition(position=1)
  @CsvCustomBindByPosition(position=1, converter = BigDecimalConverter.class)
  private BigDecimal open;
  @CsvCustomBindByPosition(position=2, converter = BigDecimalConverter.class)
  private BigDecimal high;
  @CsvCustomBindByPosition(position=3, converter = BigDecimalConverter.class)
  private BigDecimal low;
  @CsvCustomBindByPosition(position=4, converter = BigDecimalConverter.class)
  private BigDecimal close;
  @CsvCustomBindByPosition(position=5, converter = BigDecimalConverter.class)
  private BigDecimal adjustmentClose;
  @CsvCustomBindByPosition(position=6, converter = IntegerConverter.class)
  private Integer volume;

  public LocalDate getDate() {
    return date;
  }
  public BigDecimal getOpen() {
    return open;
  }
  public BigDecimal getHigh() {
    return high;
  }
  public BigDecimal getLow() {
    return low;
  }
  public BigDecimal getClose() {
    return close;
  }
  public BigDecimal getAdjustmentClose() {
    return adjustmentClose;
  }
  public Integer getVolume() {
    return volume;
  }


}
