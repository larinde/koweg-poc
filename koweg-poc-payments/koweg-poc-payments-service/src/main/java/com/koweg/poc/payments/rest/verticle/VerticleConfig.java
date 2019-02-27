package com.koweg.poc.payments.rest.verticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.koweg.poc.payments.util.ConfigVariables;

@Configuration
public class VerticleConfig {

  @Autowired
  private Environment environment;

  public int httpPort() {
    return environment.getProperty(ConfigVariables.HTTP_PORT_VAR, Integer.class, 3000);
  }
}
