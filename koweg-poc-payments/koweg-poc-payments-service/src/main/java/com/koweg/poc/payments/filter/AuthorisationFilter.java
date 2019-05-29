package com.koweg.poc.payments.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthorisationFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String jwtToken = ((HttpServletRequest)request).getHeader(HttpHeaders.AUTHORIZATION);
        if (jwtToken==null)
            log.info("*------------ MISSING AUTHORISATION VALIDATION ------------*");
        System.out.println("DONE");
        chain.doFilter(request, response);
    }
}
