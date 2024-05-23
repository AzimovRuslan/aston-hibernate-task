package io.aston.hibernatetask.repository.interfaces;

import io.aston.hibernatetask.dto.employee.EmployeeCreateRequest;
import io.aston.hibernatetask.entity.Employee;

public interface EmployeeRepository {
    Employee getById(Long id);

    Employee save(EmployeeCreateRequest employeeCreateRequest);

    Employee update(Employee employee);

    Employee delete(Employee employee);
}
