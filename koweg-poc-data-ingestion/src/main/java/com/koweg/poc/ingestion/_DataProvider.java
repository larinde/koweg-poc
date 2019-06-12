package com.koweg.poc.ingestion;

public interface _DataProvider<O, I>{
  O loadData(I source);
}