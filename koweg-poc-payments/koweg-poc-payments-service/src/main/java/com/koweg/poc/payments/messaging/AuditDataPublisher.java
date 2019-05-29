package com.koweg.poc.payments.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

public class AuditDataPublisher implements  KafkaPublisher<String, String>{

  private final KafkaTemplate<String, String> template;
  private final String topic;

  public AuditDataPublisher(KafkaTemplate<String, String> template, String topic) {
    this.template = template;
    this.topic = topic;
  }

  @Override
  public String publish(String request) {
    template.setDefaultTopic(topic);
    ListenableFuture<SendResult<String, String>> result = template.sendDefault("PAYMENT_AUDIT_DATA",request);
    return "SENT";
  }
}
