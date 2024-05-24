package io.aston.hibernatetask.repository.interfaces;

import io.aston.hibernatetask.dto.employeerole.EmployeeRoleDTO;
import io.aston.hibernatetask.entity.EmployeeRole;

import java.util.List;

public interface EmployeeRoleRepository {
    List<EmployeeRole> getAll();

    EmployeeRole getById(Long id);

    EmployeeRole save(EmployeeRoleDTO employeeRoleDTO);

    EmployeeRole update(EmployeeRole employeeRole);

    EmployeeRole delete(EmployeeRole employeeRole);
}
