# README
## 啟動專案三方服務
* 前往setup資料夾
* 執行
```
docker-compose up
```
## 關閉專案三方服務
* 前往setup資料夾
* 執行
```
docker-compose down
```
## Kafka Command 
### Create Topic
```
/opt/kafka/bin/kafka-topics.sh --zookeeper zookeeper_example:2181 --create --topic message --partitions 1 --replication-factor 1
```
### Describe Topic
```
/opt/kafka/bin/kafka-topics.sh --zookeeper zookeeper_example:2181 --describe --topic message
```
### Consume Topic
```
/opt/kafka/bin/kafka-console-consumer.sh --topic message --from-beginning --bootstrap-server localhost:9092
```
### Producer Topic
```
/opt/kafka/bin/kafka-console-producer.sh --topic message --bootstrap-server localhost:9092
```