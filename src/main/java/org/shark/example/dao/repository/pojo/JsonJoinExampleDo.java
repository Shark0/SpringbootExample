package org.shark.example.dao.repository.pojo;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "JSON_JOIN_EXAMPLE")
@Data
public class JsonJoinExampleDo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "JSON_EXAMPLE_ID")
    private Integer jsonExampleId;

    @Column(name = "DESCRIPTION")
    private String description;
}
