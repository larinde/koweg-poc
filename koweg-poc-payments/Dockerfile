FROM java:latest
MAINTAINER olarinde.ajai@gmail.com
EXPOSE 8080
ADD /koweg-poc-payments-service/target/payment-service.jar payment-service.jar
ENTRYPOINT ["java", "-jar", "payment-service.jar"]
ENV JAVA_OPTS Xmx2048 Xms1024