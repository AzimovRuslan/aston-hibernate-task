package io.aston.hibernatetask.dto.project;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddOrDeleteEmployeeRequest {
    private Long projectId;
    private Long employeeId;
}
