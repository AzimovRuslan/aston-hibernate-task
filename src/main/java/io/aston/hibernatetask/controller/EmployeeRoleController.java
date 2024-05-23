package io.aston.hibernatetask.controller;

import io.aston.hibernatetask.dto.employeerole.EmployeeRoleDTO;
import io.aston.hibernatetask.entity.EmployeeRole;
import io.aston.hibernatetask.repository.interfaces.EmployeeRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v0/employee-roles")
@AllArgsConstructor
public class EmployeeRoleController {

    private final EmployeeRoleRepository employeeRoleRepository;

    @GetMapping("/{id}")
    public EmployeeRole getById(@PathVariable("id") Long id) {
            return employeeRoleRepository.getById(id);
    }

    @PostMapping
    public EmployeeRole save(@RequestBody EmployeeRoleDTO employeeRoleDTO) {
        return employeeRoleRepository.save(employeeRoleDTO);
    }
}
