package io.aston.hibernatetask.dto.employeerole;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EmployeeRoleDTO {

    @NotBlank(message = "name can't be empty")
    private String name;
}
