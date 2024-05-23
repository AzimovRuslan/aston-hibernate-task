package io.aston.hibernatetask.dto.employee;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EmployeeCreateRequest {
    @NotBlank(message = "name can't be empty")
    private String name;

    @NotBlank(message = "surname can't be empty")
    private String surname;

    @NotBlank(message = "roleId can't be empty")
    private Long roleId;

    @NotNull(message = "personalInfoId can't be empty")
    private Long personalInfoId;
}
