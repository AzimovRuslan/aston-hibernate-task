package io.aston.hibernatetask.service;

import io.aston.hibernatetask.dto.employee.EmployeeCreateRequest;
import io.aston.hibernatetask.entity.Employee;
import io.aston.hibernatetask.repository.interfaces.EmployeeRepository;
import io.aston.hibernatetask.service.interfaces.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public Employee save(EmployeeCreateRequest employeeCreateRequest) {
        return employeeRepository.save(employeeCreateRequest);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public Employee delete(Employee employee) {
        return employeeRepository.delete(employee);
    }
}
