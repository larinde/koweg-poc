FROM java:latest
MAINTAINER olarinde.ajai@gmail.com
VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} payment-service.jar
COPY /koweg-poc-payments-service/target/payment-service.jar payment-service.jar
ENV JAVA_OPTS Xmx2048 Xms1024
ENTRYPOINT ["java", "-jar", "payment-service.jar"]

