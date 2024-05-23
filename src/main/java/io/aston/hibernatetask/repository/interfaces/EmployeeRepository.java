package io.aston.hibernatetask.repository.interfaces;

import io.aston.hibernatetask.dto.employee.EmployeeCreateRequest;
import io.aston.hibernatetask.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAll();

    Employee getById(Long id);

    Employee save(EmployeeCreateRequest employeeCreateRequest);

    Employee update(Employee employee);

    Employee delete(Employee employee);
}
