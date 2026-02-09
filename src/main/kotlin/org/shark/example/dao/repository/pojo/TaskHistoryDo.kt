package org.shark.example.dao.repository.pojo

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.shark.example.config.jackson.InstantToMillisecondsSerializer
import java.time.Instant

@Entity
@Table(name = "TASK_HISTORY")
data class TaskHistoryDo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Int? = null,

    @Column(name = "TASK_ID")
    var taskId: Int? = null,

    @Column(name = "WORK_ID")
    var workId: String? = null,

    @Column(name = "STATUS")
    var status: Int? = null,

    @JsonSerialize(using = InstantToMillisecondsSerializer::class)
    @CreationTimestamp
    @Column(name = "CREATE_TIME", nullable = false, updatable = false)
    var createTime: Instant? = null
)
