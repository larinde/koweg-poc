package com.koweg.poc.payments.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.joda.time.DateTime;

import com.koweg.poc.payments.rest.representation.Payment;

public class PaymentServiceImpl implements PaymentService {

  private static Map<Long, Payment> paymentList;
  private static AtomicLong paymentId = new AtomicLong(0);

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
  public Collection<Payment> getPayments() {
    return Collections.list(Collections.enumeration(paymentList.values()));
  }

}
