java -jar koweg-poc-audit-service/target/koweg-poc-audit-service.jar


curl -X POST -H "Content-Type: application/json;charset=utf-8" --data-binary "{\"auditContext\": \"PAYMENT_HISTORY_REQUESTED\", \"date\": \"2017-12-25T14:21:41\", \"requestId\": \"85a9cd3429b8\", \"correlationId\": \"37a9cd3429b8\"}"    http://localhost:9300/audits -v

curl -X POST -H "Content-Type: application/json;charset=utf-8" --data-binary "{\"auditContext\": \"PAYMENT_INITIATED\", \"date\": \"2016-03-04T10:15:30\", \"requestId\": \"ab124cd\",  \"correlationId\": \"ab124cd\"}"    http://localhost:9300/audits -v
