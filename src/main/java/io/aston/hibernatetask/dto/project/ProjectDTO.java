package io.aston.hibernatetask.dto.project;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProjectDTO {
    @NotBlank(message = "name can't be empty")
    private String name;
}
