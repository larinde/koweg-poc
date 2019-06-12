package com.koweg.poc.ingestion;

import com.koweg.poc.ingestion.model.StockData;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;


import static org.hamcrest.CoreMatchers.is;
import  static  org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import static org.hamcrest.MatcherAssert.assertThat;

public class StockDataProviderTest {

  DataProvider provider = new StockDataProvider();

  @Test
  void shouldSuccessfullyLoadDataFromCsvFile() throws Exception {
    final URL url = getClass().getClassLoader().getResource("testdata/AMAT_historical_stock_data.csv");


    final List<StockData> data = provider.loadData(url);
    assertThat(data, is(notNullValue()));
    assertThat(data.size(), is(equalTo(9865)));
/*
    System.out.println(url.toURI().toString());
    System.out.println(data.size());
*/
  }

  @Test
  void shouldThrowExceptionForUnavailableDataSource() throws Exception {
    final URL url = getClass().getClassLoader().getResource("falseTestDataPath/AMAT_historical_stock_data.csv");
    Assertions.assertThrows(UnableToIngestDataException.class, () -> provider.loadData(url));
  }
}
