package io.aston.hibernatetask.controller;

import io.aston.hibernatetask.dto.employee.EmployeeCreateRequest;
import io.aston.hibernatetask.entity.Employee;
import io.aston.hibernatetask.exception.IncorrectInputException;
import io.aston.hibernatetask.service.interfaces.EmployeeService;
import io.aston.hibernatetask.utility.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/employees")
@AllArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Employee getById(@PathVariable("id") Long id) {
        Employee employee = employeeService.getById(id);

        if (employee == null) {
            log.error(Constants.INCORRECT_ID + Constants.REQUEST_FAILED);
            throw new IncorrectInputException(Constants.INCORRECT_ID);
        }

        log.info(Constants.EMPLOYEE + Constants.FOUND + Constants.WITH_ID + id);
        return employee;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee save(@RequestBody EmployeeCreateRequest employeeCreateRequest) {
        Employee employee = employeeService.save(employeeCreateRequest);
        log.info(Constants.EMPLOYEE + Constants.SUCCESSFUL_SAVE + employee);
        return employee;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee update(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.update(employee);
        log.info(Constants.EMPLOYEE + Constants.SUCCESSFUL_UPDATE);
        return updatedEmployee;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Employee delete(@RequestBody Employee employee) {
        Employee deletedEmployee = employeeService.delete(employee);
        log.info(Constants.EMPLOYEE + Constants.SUCCESSFUL_DELETE);
        return deletedEmployee;
    }
}
