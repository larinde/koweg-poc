properties from external config files
--------------------------------------
java -jar koweg-poc-payments-service/target/payment-service.jar --spring.config.location=classpath:/another-location.properties


properties from command line args
----------------------------------
java -jar koweg-poc-payments-service/target/payment-service.jar --server.port="7777"

java -Dproperty.server.port="7777" -jar koweg-poc-payments-service/target/payment-service.jar


properties from environment variables
--------------------------------------
export APP_SERVER_PORT="7777"

java -jar koweg-poc-payments-service/target/payment-service.jar

--------------------------------------------------------------------------------------------------
curl -X GET -H "Accept: application/json" http://localhost:7733/payments/history -v
--------------------------------------------------------------------------------------------------
curl -X POST -H "Content-Type: application/json;charset=utf-8" --data-binary "{\"auditContext\": \"PAYMENT_INITIATED\", \"date\": \"2016-03-04T10:15:30\", \"requestId\": \"ab124cd\",  \"correlationId\": \"ab124cd\"}"    http://localhost:9300/audits -v



#export POSTGRES_INITDB_ARGS
export POSTGRES_DB="payment"
export POSTGRES_USER="larinde"
export POSTGRES_PASSWORD="larinde"

#docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
#docker run --name some-postgres -e POSTGRES_PASSWORD_FILE=/run/secrets/postgres-passwd -d postgres


sudo docker run --name payment_ms_db -d postgres -p 5432
sudo docker exec -it payment_ms_db psql -U postgres


```dockerfile
FROM postgres:latest
ENV LANG en_GB.utf8

---------------------------------------------------------------------------------------------
docker run -d -p 49160:22 -p 49161:1521 -e ORACLE_ALLOW_REMOTE=true --name oracle-xe  wnameless/oracle-xe-11g
