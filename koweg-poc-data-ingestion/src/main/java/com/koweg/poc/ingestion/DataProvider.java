package com.koweg.poc.ingestion;

import com.koweg.poc.ingestion.model.StockData;

import java.net.URI;
import java.net.URL;
import java.util.List;

public interface DataProvider {
  List<StockData> loadData(URL source);
}
