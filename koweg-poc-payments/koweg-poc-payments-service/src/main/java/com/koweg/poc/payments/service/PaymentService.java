package com.koweg.poc.payments.service;

import java.util.Collection;
import java.util.List;

import com.koweg.poc.payments.rest.representation.Payment;

public interface PaymentService {

  List<Payment> getPayments();
}
