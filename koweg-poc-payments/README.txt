curl -X GET -H "Accept: application/json" http://localhost:9100/payments/history -v

curl -X GET -H "Accept: application/json" http://localhost:3000/payments/3 -v

curl -X DELETE http://localhost:3000/payments/cancel/4 -v

curl -X PUT  --data-binary "{\"id\":4,\"amount\":3000.97,\"date\":1004517289622, \"currency\":\"GBP\" }" -H "Content-Type: application/json"   http://localhost:3000/payments/update -v



#yyyy-MM-dd'T'HH:mm:ss.SSSZ \"2016-02-06 19:31:37.000+02:00 \"
curl -X POST -H "Content-Type: application/json;charset=utf-8" --data-binary "{\"id\":7, \"amount\":333.97,\"date\":1004517299622, \"currency\":\"USD\"}"    http://localhost:3000/payments/authorize -v


curl -X POST -H "Content-Type: application/json" --data-binary "{"id":0,"amount":333.97,"date":"05-07-2014","currency":"EUR"}"    http://localhost:3000/payments/authorize -v

-----------------------------------------------------------------------------------


curl -X GET -H "Accept: application/json" http://localhost:3000/payments/history -v



curl -X DELETE http://localhost:3000/payments/cancel/4 -v

curl -X POST  --data-binary "{\"id\":0,\"amount\":999.13,\"date\":1074517289622, \"currency\":\"USD\" }" -H "Content-Type: application/json"   http://localhost:3000/payments/authorize -v

curl -X PUT  --data-binary "{\"id\":1,\"amount\":333.97,\"date\":1004517289622, \"currency\":\"GBP\" }" -H "Content-Type: application/json"   http://localhost:3000/payments/update -v




curl -X GET http://localhost:3000/payments/monitoring/info?format=json
{"appName":"epayment","appVersion":"0.0.1"}

curl -X GET http://localhost:3000/payments/monitoring/info?format=text
ApplicationInfo [appName=epayment, appVersion=0.0.1]

curl -X GET -H "Accept: text/plain" http://localhost:3000/payments/monitoring/info
ApplicationInfo [appName=epayment, appVersion=0.0.1]

curl -X GET -H "Accept: application/json" http://localhost:3000/payment/monitoring/info
{"appName":"epayment","appVersion":"0.0.1"}
