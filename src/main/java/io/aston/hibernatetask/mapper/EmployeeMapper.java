package io.aston.hibernatetask.mapper;

import io.aston.hibernatetask.dto.employee.EmployeeCreateRequest;
import io.aston.hibernatetask.dto.employee.EmployeeDTO;
import io.aston.hibernatetask.entity.Employee;
import io.aston.hibernatetask.service.interfaces.EmployeePersonalInfoService;
import io.aston.hibernatetask.service.interfaces.EmployeeRoleService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Data
public class EmployeeMapper implements IMapper<Employee, EmployeeDTO> {

    private final ModelMapper modelMapper;
    private final EmployeeRoleService employeeRoleService;
    private final EmployeePersonalInfoService employeePersonalInfoService;

    @Override
    public EmployeeDTO toDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public Employee toEntity(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }

    public Employee employeeCreateRequestToEntity(EmployeeCreateRequest employeeCreateRequest) {
        Employee employee = new Employee();
        employee.setName(employeeCreateRequest.getName());
        employee.setSurname(employeeCreateRequest.getSurname());
        employee.setRole(employeeRoleService.getById(employeeCreateRequest.getRoleId()));
        employee.setPersonalInfo(employeePersonalInfoService.getById(employeeCreateRequest.getPersonalInfoId()));
        return employee;
    }
}
