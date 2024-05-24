package io.aston.hibernatetask.dto.employee;

import io.aston.hibernatetask.entity.EmployeePersonalInfo;
import io.aston.hibernatetask.entity.EmployeeRole;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class EmployeeDTO {

    @NotBlank(message = "name can't be empty")
    private String name;

    @NotBlank(message = "surname can't be empty")
    private String surname;

    @NotEmpty(message = "role can't be empty")
    private EmployeeRole role;

    @NotEmpty(message = "personalInfo can't be empty")
    private EmployeePersonalInfo personalInfo;
}
