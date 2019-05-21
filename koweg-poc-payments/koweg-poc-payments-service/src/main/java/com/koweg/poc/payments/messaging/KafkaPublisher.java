package com.koweg.poc.payments.messaging;

public interface KafkaPublisher <Req, Res>{
  public Res publish(Req request);
}
