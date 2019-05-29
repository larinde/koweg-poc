package com.koweg.poc.payments.rest.resource.filters;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class TransactionIdFilter implements Filter {

  private static final String TRANS_ID_KEY = "transId";

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    try {
      MDC.put(TRANS_ID_KEY, UUID.randomUUID().toString());
      chain.doFilter(request, response);
    } finally {
      MDC.clear();
    }
  }
}
