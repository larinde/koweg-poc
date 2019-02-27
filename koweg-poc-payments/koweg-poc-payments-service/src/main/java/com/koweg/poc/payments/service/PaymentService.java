package com.koweg.poc.payments.service;

import java.util.Collection;

import com.koweg.poc.payments.rest.representation.Payment;

public interface PaymentService {

  Collection<Payment> getPayments();
}
