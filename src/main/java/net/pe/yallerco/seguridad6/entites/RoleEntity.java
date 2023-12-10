package net.pe.yallerco.seguridad6.entites;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "roles")
@Data
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "role_name")
    private String name;
    private String description;
}
