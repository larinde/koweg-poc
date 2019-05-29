Start Zoo Keeper
----------------
 ./bin/zookeeper-server-start.sh config/zookeeper.properties


Start Kafka server
-------------------
 ./bin/kafka-server-start.sh config/server.properties

create a topic
--------------
./bin/kafka-topics.sh --create --zookeeper localhost:2181 --topic audit-topic --partitions 1 --replication-factor 1


###############################################################################
Service Registry Setup
=======================

application.properties
-----------------------
#export APP_KOWEG_POC_REGISTRY_SERVER_PORT="9000"
server.port=${APP_KOWEG_POC_REGISTRY_SERVER_PORT}

#prevent this registry instance from registering itself as a client
eureka.client.register-with-eureka=false

#prevent this registry instance from fetching registry entries from any other instance
eureka.client.fetch-registry=false



