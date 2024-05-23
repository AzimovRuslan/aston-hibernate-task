package io.aston.hibernatetask.entity;

import io.aston.hibernatetask.repository.interfaces.EmployeeRoleRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employee_roles")
public class EmployeeRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "name can't be empty")
    private String role;

    public EmployeeRole(String role) {
        this.role = role;
    }
}
