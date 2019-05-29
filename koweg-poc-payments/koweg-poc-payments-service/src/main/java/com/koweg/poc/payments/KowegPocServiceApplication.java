package com.koweg.poc.payments;

import javax.annotation.PostConstruct;

import com.koweg.poc.payments.filter.AuthorisationFilter;
import com.koweg.poc.payments.service.PaymentService;
import com.koweg.poc.payments.service.PaymentServiceImpl;
 //import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.koweg.poc.payments.rest.verticle.PaymentVerticle;
import com.koweg.poc.payments.rest.verticle.VerticleConfig;

import io.vertx.core.Vertx;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.client.RestTemplate;
import org.apache.kafka.clients.admin.NewTopic;

import com.koweg.poc.payments.messaging.AuditDataPublisher;

@SpringBootApplication
@EnableEurekaClient
public class KowegPocServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(KowegPocServiceApplication.class, args);
  }

  @Autowired
  public Environment environment;

  //for manual load-balancing in the client-side
   //@Autowired
   //private DiscoveryClient discoveryClient;

  @Bean
  public FilterRegistrationBean filterRegistration() {
    return new FilterRegistrationBean(new AuthorisationFilter());
  }


  @Bean
  public PaymentService paymentService(){
    return  new PaymentServiceImpl(restCallTemplate(), environment.getProperty("audit.service.name").toString());
  }

  @Bean
  @LoadBalanced
  public RestTemplate restCallTemplate(){
    return new RestTemplate();
  }

  @Autowired
  private PaymentVerticle paymentVerticle;

  @Bean
  public PaymentService paymentService(){
    return  new PaymentServiceImpl(auditDataPublisher(), restCallTemplate(), environment.getProperty("audit.service.name").toString());
  }

  @Bean
  @LoadBalanced
  public RestTemplate restCallTemplate(){
    return new RestTemplate();
  }

   // @Autowired
  //  private PaymentVerticle paymentVerticle;

  //  @Bean
  //  @Autowired
  //  public PaymentVerticle paymentVerticle(VerticleConfig config) {
  //    return new PaymentVerticle(config);
  //  }

  //  @PostConstruct
  //  private void deployVerticle() {
   //   Vertx.vertx().deployVerticle(paymentVerticle);
  //  }

  @Autowired
  public KafkaTemplate<String, String> kafkaTemplate;


	@Bean
	public AuditDataPublisher auditDataPublisher() {
		return new AuditDataPublisher(kafkaTemplate, "audit");
	}


	@Bean
	public NewTopic audit() {
		return new NewTopic("audit", 1, (short) 1);
	}


//  @KafkaListener(topics = "audit", groupId = "auditDataGroup")
//  public void auditDataListener(String data){
//    System.out.println("Receiving --->" + data);
//  }

}
