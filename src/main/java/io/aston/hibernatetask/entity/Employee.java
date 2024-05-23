package io.aston.hibernatetask.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "name can't be empty")
    private String name;

    @Column(name = "surname", nullable = false)
    @NotBlank(message = "surname can't be empty")
    private String surname;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private EmployeeRole role;

    @OneToOne
    @JoinColumn(name = "personal_info_id")
    private EmployeePersonalInfo personalInfo;
}
