package io.aston.hibernatetask.dto.employeepersonalinfo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EmployeePersonalInfoDTO {

    @NotBlank(message = "email can't be empty")
    private String email;

    @NotBlank(message = "phone can't be empty")
    private String phone;
}
