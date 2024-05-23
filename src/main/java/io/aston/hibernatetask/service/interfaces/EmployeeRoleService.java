package io.aston.hibernatetask.service.interfaces;

import io.aston.hibernatetask.dto.employeerole.EmployeeRoleDTO;
import io.aston.hibernatetask.entity.EmployeeRole;

public interface EmployeeRoleService {
    EmployeeRole getById(Long id);

    EmployeeRole save(EmployeeRoleDTO employeeRoleDTO);

    EmployeeRole update(EmployeeRole employeeRole);

    EmployeeRole delete(EmployeeRole employeeRole);
}
