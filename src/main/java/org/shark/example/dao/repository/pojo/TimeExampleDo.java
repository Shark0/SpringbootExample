package org.shark.example.dao.repository.pojo;

import java.time.Instant;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "TIME_EXAMPLE")
@Data
public class TimeExampleDo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CREATE_TIME")
    private Instant createTime;
}