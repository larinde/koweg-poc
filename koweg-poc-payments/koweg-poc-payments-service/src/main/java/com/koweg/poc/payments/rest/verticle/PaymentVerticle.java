package com.koweg.poc.payments.rest.verticle;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.koweg.poc.payments.rest.representation.Payment;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class PaymentVerticle extends AbstractVerticle {

  private final VerticleConfig config;
  private final ObjectMapper mapper;
  private static Map<Long, Payment> paymentList;
  private static AtomicLong paymentId = new AtomicLong(0);

  public PaymentVerticle(VerticleConfig config) {
    this.config = config;
    mapper = Json.mapper;
  }

  @Override
  public void start() throws Exception {
    super.start();
    Router router = Router.router(vertx);
    router.route().handler(BodyHandler.create());
    router.get("/payments").handler(this::getPayments);

    vertx.createHttpServer().requestHandler(router::accept).listen(config.httpPort());

  }

  private void getPayments(RoutingContext context) {
    try {
      context.response().setStatusCode(200).putHeader("content-type", "application/json")
          .end(mapper.writeValueAsString(Collections.list(Collections.enumeration(paymentList.values()))));
    } catch (JsonProcessingException e) {
      // FIXME
      System.out.println("------- FIX ME ------- ");
      e.printStackTrace();
    }

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

}
