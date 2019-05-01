package com.koweg.poc.payments;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;

import com.koweg.poc.payments.filter.AuthorisationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koweg.poc.payments.rest.verticle.PaymentVerticle;
import com.koweg.poc.payments.rest.verticle.VerticleConfig;

import io.vertx.core.Vertx;

@SpringBootApplication
public class KowegPocServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(KowegPocServiceApplication.class, args);
  }

  @Bean
  public FilterRegistrationBean filterRegistration() {
    return new FilterRegistrationBean(new AuthorisationFilter());
  }

  @Autowired
  private PaymentVerticle paymentVerticle;

  @Bean
  @Autowired
  public PaymentVerticle paymentVerticle(VerticleConfig config) {
    return new PaymentVerticle(config);
  }

  @PostConstruct
  private void deployVerticle() {
    Vertx.vertx().deployVerticle(paymentVerticle);

  }

}
