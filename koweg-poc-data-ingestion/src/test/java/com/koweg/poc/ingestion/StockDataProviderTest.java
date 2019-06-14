package com.koweg.poc.ingestion;

import com.koweg.poc.ingestion.model.StockData;
import org.junit.jupiter.api.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.CoreMatchers.is;
import  static  org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import static org.hamcrest.MatcherAssert.assertThat;

public class StockDataProviderTest {

  DataProvider provider = new StockDataProvider();

  @BeforeEach
  public  void init(){

  }

  @AfterEach
  public void clean(){

  }

  @Test
  @DisplayName("should successfully load and ingest a data source")
  void shouldSuccessfullyLoadDataFromCsvFile() {
    final URL url = getClass().getClassLoader().getResource("testdata/AMAT_historical_stock_data.csv");
    final List<StockData> data = provider.loadData(url);
    assertThat(data, is(notNullValue()));
    assertThat(data.size(), is(equalTo(9865)));

  }

  @Test
  @DisplayName("should throw exception when data source is unavailable")
  void shouldThrowExceptionWhenDataSourceIsUnavailable() {
    final URL url = getClass().getClassLoader().getResource("testdata/unavailable_AMAT_historical_stock_data.csv");
    Assertions.assertThrows(UnableToIngestDataException.class, () -> provider.loadData(url));
  }
}
