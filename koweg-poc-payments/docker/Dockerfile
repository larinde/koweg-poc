FROM java:latest
MAINTAINER olarinde.ajai@gmail.com
VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} koweg-poc-payments-service.jar
COPY /koweg-poc-payments-service/targetkoweg-poc-payments-service.jar payment-service.jar
ENV JAVA_OPTS Xmx2048 Xms1024
ENTRYPOINT ["java", "-jar", "payment-service.jar"]

