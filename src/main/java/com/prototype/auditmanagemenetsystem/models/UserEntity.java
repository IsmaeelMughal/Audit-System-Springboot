package com.prototype.auditmanagemenetsystem.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String name;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @OneToMany(mappedBy = "assignedBy")
    private List<AuditEntity> auditsAssignedBy;

    @OneToMany(mappedBy = "assignedTo")
    private List<AuditEntity> auditsAssignedTo;
}
