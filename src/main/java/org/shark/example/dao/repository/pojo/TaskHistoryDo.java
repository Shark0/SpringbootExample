package org.shark.example.dao.repository.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.shark.example.config.jackson.InstantToMillisecondsSerializer;

import java.time.Instant;

@Entity
@Table(name = "TASK_HISTORY")
@Data
public class TaskHistoryDo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TASK_ID")
    private Integer taskId;

    @Column(name = "WORK_ID")
    private String workId;

    @Column(name = "STATUS")
    private Integer status;

    @JsonSerialize(using = InstantToMillisecondsSerializer.class)
    @CreationTimestamp
    @Column(name = "CREATE_TIME", nullable = false, updatable = false)
    private Instant createTime;
}