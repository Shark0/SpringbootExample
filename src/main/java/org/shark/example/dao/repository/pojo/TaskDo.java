package org.shark.example.dao.repository.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.shark.example.config.jackson.InstantToMillisecondsSerializer;

import java.time.Instant;

@Entity
@Table(name = "TASK")
@Data
public class TaskDo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "WORK_ID")
    private String workId;

    @JsonSerialize(using = InstantToMillisecondsSerializer.class)
    @CreationTimestamp
    @Column(name = "CREATE_TIME", nullable = false, updatable = false)
    private Instant createTime;

    @JsonSerialize(using = InstantToMillisecondsSerializer.class)
    @UpdateTimestamp
    @Column(name = "UPDATE_TIME", nullable = false)
    private Instant updateTime;
}
