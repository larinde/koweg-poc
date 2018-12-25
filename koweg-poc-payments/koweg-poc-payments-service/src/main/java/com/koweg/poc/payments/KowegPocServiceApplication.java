package com.koweg.poc.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class KowegPocServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(KowegPocServiceApplication.class, args);
  }
 
  @RestController
  public class Demo{
    @RequestMapping("/testing")
    public String name() {
      return "TEST RUN";
    }
  }

}
