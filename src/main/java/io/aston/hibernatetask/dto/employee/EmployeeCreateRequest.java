package io.aston.hibernatetask.dto.employee;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EmployeeCreateRequest {
    @NotBlank(message = "name can't be empty")
    private String name;

    @NotBlank(message = "surname can't be empty")
    private String surname;

    private Long roleId;

    private Long personalInfoId;
}
