package com.koweg.poc.payments.service;

import com.koweg.poc.payments.rest.representation.Payment;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Adapter {

    public static void main(String[] args){

        Payment payment = new Payment(1l, BigDecimal.valueOf(33.7), Date.from(Instant.now()), "EUR");



        Runnable processor = () -> {};

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(processor);


    }

    public class Worker implements  Runnable{
        @Override
        public void run() {

        }
    }
}

