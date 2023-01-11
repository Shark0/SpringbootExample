package org.shark.example.dao.repository.pojo;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "WORK_HISTORY")
@Data
public class WorkHistoryDo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TASK_ID")
    private Integer taskId;
}
