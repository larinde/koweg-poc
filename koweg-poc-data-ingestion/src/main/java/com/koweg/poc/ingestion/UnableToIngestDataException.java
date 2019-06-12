package com.koweg.poc.ingestion;

public class UnableToIngestDataException extends RuntimeException {

  public UnableToIngestDataException(Throwable cause) {
    super(cause);
  }
}
