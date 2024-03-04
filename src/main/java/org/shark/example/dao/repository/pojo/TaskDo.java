package org.shark.example.dao.repository.pojo;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "TASK")
@Data
public class TaskDo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TASK_NAME")
    private String name;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "CHECK_ID")
    private String checkId;
}
