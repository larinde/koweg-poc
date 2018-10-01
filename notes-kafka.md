Start Zoo Keeper
----------------
 ./bin/zookeeper-server-start.sh config/zookeeper.properties


Start Kafka server
-------------------
 ./bin/kafka-server-start.sh config/server.properties

create a topic
--------------
./bin/kafka-topics.sh --create --zookeeper localhost:2181 --topic payments-audit --partitions 1 --replication-factor 1
