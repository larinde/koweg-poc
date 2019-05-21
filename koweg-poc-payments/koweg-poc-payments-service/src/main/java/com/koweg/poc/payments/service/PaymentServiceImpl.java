package com.koweg.poc.payments.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.joda.time.DateTime;

import com.koweg.poc.payments.rest.representation.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class PaymentServiceImpl implements PaymentService {

  private static Map<Long, Payment> paymentList;

  private static AtomicLong paymentId = new AtomicLong(0);

  private final RestTemplate restTemplate;

  private final String auditServiceName;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public PaymentServiceImpl(RestTemplate restTemplate, String auditServiceName){
    this.restTemplate = restTemplate;
    this.auditServiceName = auditServiceName;
  }

  static {
    paymentList = new ConcurrentHashMap<Long, Payment>();
    paymentList.put(paymentId.incrementAndGet(),
        new Payment(paymentId.get(), new BigDecimal("700370.50"), DateTime.now().toDate(), "USD"));
    paymentList.put(paymentId.incrementAndGet(),
        new Payment(paymentId.get(), new BigDecimal("43.3"), DateTime.now().toDate(), "EUR"));
    paymentList.put(paymentId.incrementAndGet(),
        new Payment(paymentId.get(), new BigDecimal("79.7"), DateTime.now().toDate(), "EUR"));
    paymentList.put(paymentId.incrementAndGet(),
        new Payment(paymentId.get(), new BigDecimal("89.7"), DateTime.now().toDate(), "EUR"));
  }


  @Override
  public List<Payment> getPayments() {
    auditCall("PAYMENT_HISTORY_REQUESTED");
   // return Collections.list(Collections.enumeration(paymentList.values()));
    return  Collections.list(Collections.enumeration(paymentList.values()));
  }

  private void auditCall(String auditJournal) {
    logger.info("---  Auditing {} journal  on remote service --> {} ---", auditJournal, auditServiceName);
    Audit audit = new Audit(auditJournal,
            LocalDateTime.now(),
            UUID.randomUUID().toString().replaceAll("-", ""),
            UUID.randomUUID().toString().replaceAll("-", ""),
            ""
    );
    HttpEntity<Audit> entity = new HttpEntity<Audit>(audit);
    restTemplate.exchange("http://"+ auditServiceName + "/audits", HttpMethod.POST,entity, Audit.class);
  }

}
