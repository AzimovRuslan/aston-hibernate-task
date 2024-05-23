package io.aston.hibernatetask.controller;

import io.aston.hibernatetask.dto.employeerole.EmployeeRoleDTO;
import io.aston.hibernatetask.entity.EmployeeRole;
import io.aston.hibernatetask.exception.IncorrectInputException;
import io.aston.hibernatetask.service.interfaces.EmployeeRoleService;
import io.aston.hibernatetask.utility.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v0/employee-roles")
@AllArgsConstructor
@Slf4j
public class EmployeeRoleController {

    private final EmployeeRoleService employeeRoleService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public EmployeeRole getById(@PathVariable("id") Long id) {
        EmployeeRole employeeRole = employeeRoleService.getById(id);

        if (employeeRole == null) {
            log.error(Constants.INCORRECT_ID + Constants.REQUEST_FAILED);
            throw new IncorrectInputException(Constants.INCORRECT_ID);

        }

        log.info(Constants.EMPLOYEE_ROLE + Constants.FOUND + Constants.WITH_ID + id);
        return employeeRole;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeRole save(@RequestBody EmployeeRoleDTO employeeRoleDTO) {
        EmployeeRole employeeRole = employeeRoleService.save(employeeRoleDTO);
        log.info(Constants.EMPLOYEE_ROLE + Constants.SUCCESSFUL_SAVE + employeeRole);
        return employeeRole;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeRole update(@RequestBody EmployeeRole employeeRole) {
        EmployeeRole updatedRole = employeeRoleService.update(employeeRole);
        log.info(Constants.EMPLOYEE_ROLE + Constants.SUCCESSFUL_UPDATE);
        return updatedRole;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EmployeeRole delete(@RequestBody EmployeeRole employeeRole) {
        EmployeeRole deletedRole = employeeRoleService.delete(employeeRole);
        log.info(Constants.EMPLOYEE_ROLE + Constants.SUCCESSFUL_DELETE);
        return deletedRole;
    }

}
