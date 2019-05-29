package com.koweg.poc.audit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import io.vertx.core.Vertx;

@SpringBootApplication
public class KowegPocAuditApplication {

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(KowegPocAuditApplication.class, args);
    }

    @Bean
    public AuditVerticle auditVerticle() {
        return new AuditVerticle(environment);
    }

    @PostConstruct
    public void deployVerticles() {
        Vertx.vertx().deployVerticle(auditVerticle());
    }
}
