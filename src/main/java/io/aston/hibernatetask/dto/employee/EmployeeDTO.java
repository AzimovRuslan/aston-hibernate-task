package io.aston.hibernatetask.dto.employee;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EmployeeDTO {

    @NotBlank(message = "name can't be empty")
    private String name;

    @NotBlank(message = "surname can't be empty")
    private String surname;

    private String role;

    private String personalInfo;
}
