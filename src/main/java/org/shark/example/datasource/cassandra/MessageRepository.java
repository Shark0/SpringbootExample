package org.shark.example.datasource.cassandra;

import org.shark.example.datasource.cassandra.pojo.MessageDo;
import org.shark.example.datasource.cassandra.pojo.MessageKeyDo;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface MessageRepository extends CassandraRepository<MessageDo, MessageKeyDo> {

}
