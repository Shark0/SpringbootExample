package org.shark.example.dao.repository.pojo

import jakarta.persistence.*

@Entity
@Table(name = "JSON_EXAMPLE")
data class JsonExampleDo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Int? = null,

    @Column(name = "JSON_DATA")
    var jsonData: String? = null
)
