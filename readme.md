# README

## ScyllaDB Setup

To run this project, you need a ScyllaDB (or Cassandra) instance running locally.

### 1. Start ScyllaDB via Docker Compose
```bash
docker compose up
```

### 2. Create Keyspace and Table
You can use the provided `src/main/resources/schema.cql` file or run the following commands in `cqlsh`:

```bash
docker exec -it scylla-node1 cqlsh
```

Inside cqlsh:
```sql
CREATE KEYSPACE IF NOT EXISTS example
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE example;

CREATE TABLE IF NOT EXISTS message (
    user_id bigint,
    user_service text,
    item_id bigint,
    time timestamp,
    PRIMARY KEY ((user_id, user_service), item_id)
);
```
