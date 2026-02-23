# README
## Cassandra
Exec Docker
```
docker exec -it cassandra_example cqlsh
```
Create Keyspace 'example'
```
CREATE KEYSPACE example 
WITH replication = {
    'class': 'SimpleStrategy', 
    'replication_factor': 1
};
```
