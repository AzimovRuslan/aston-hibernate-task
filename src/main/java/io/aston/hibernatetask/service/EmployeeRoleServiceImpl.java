package io.aston.hibernatetask.service;

import io.aston.hibernatetask.dto.employeerole.EmployeeRoleDTO;
import io.aston.hibernatetask.entity.EmployeeRole;
import io.aston.hibernatetask.repository.interfaces.EmployeeRoleRepository;
import io.aston.hibernatetask.service.interfaces.EmployeeRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeRoleServiceImpl implements EmployeeRoleService {

    private final EmployeeRoleRepository employeeRoleRepository;


    @Override
    public EmployeeRole getById(Long id) {
        return employeeRoleRepository.getById(id);
    }

    @Override
    public EmployeeRole save(EmployeeRoleDTO employeeRoleDTO) {
        return employeeRoleRepository.save(employeeRoleDTO);
    }

    @Override
    public EmployeeRole update(EmployeeRole employeeRole) {
        return employeeRoleRepository.update(employeeRole);
    }

    @Override
    public EmployeeRole delete(EmployeeRole employeeRole) {
        return employeeRoleRepository.delete(employeeRole);
    }
}
