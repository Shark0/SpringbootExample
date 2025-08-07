package org.shark.example.domain.user.adapter.outbound.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "USER")
@Entity
public class UserDo {
    @Id
    private String id;
    private String name;
    private String email;
}
