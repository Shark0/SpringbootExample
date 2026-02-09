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
