package com.koweg.poc.ingestion;


import com.koweg.poc.ingestion.model.StockData;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StockDataProvider implements DataProvider {

  private static final int HEADER_LINES = 1;

  @Override
  public List<StockData> loadData(URL source) {
    try(BufferedReader reader = Files.newBufferedReader(Paths.get(source.toURI()))) {
      final ColumnPositionMappingStrategy<StockData> mappingStrategy = new ColumnPositionMappingStrategy<>();
      mappingStrategy.setType(StockData.class);
      final CsvToBeanBuilder<StockData> builder = new CsvToBeanBuilder<>(reader);
      final CsvToBean<StockData> csvToBean = builder
              .withMappingStrategy(mappingStrategy)
              .withSkipLines(HEADER_LINES)
              .build();
      return csvToBean.parse();
    }catch (Exception ex){
      throw  new UnableToIngestDataException(ex);
    }
  }
}
