package org.shark.example.dao.repository.pojo;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "JSON_EXAMPLE")
@Data
public class JsonExampleDo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "JSON_DATA")
    private String jsonData;
}
