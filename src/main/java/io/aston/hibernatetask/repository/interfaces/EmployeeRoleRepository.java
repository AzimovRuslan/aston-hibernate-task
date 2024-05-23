package io.aston.hibernatetask.repository.interfaces;

import io.aston.hibernatetask.dto.employeerole.EmployeeRoleDTO;
import io.aston.hibernatetask.entity.EmployeeRole;

public interface EmployeeRoleRepository {
    EmployeeRole getById(Long id);

    EmployeeRole save(EmployeeRoleDTO employeeRoleDTO);
}
