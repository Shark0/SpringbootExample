package org.shark.example.dao.repository.pojo

import jakarta.persistence.*

@Entity
@Table(name = "JSON_JOIN_EXAMPLE")
data class JsonJoinExampleDo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Int? = null,

    @Column(name = "JSON_EXAMPLE_ID")
    var jsonExampleId: Int? = null,

    @Column(name = "DESCRIPTION")
    var description: String? = null
)
