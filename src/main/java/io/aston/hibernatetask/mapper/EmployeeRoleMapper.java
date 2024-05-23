package io.aston.hibernatetask.mapper;

import io.aston.hibernatetask.dto.employeerole.EmployeeRoleDTO;
import io.aston.hibernatetask.entity.EmployeeRole;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class EmployeeRoleMapper {

    @Autowired
    private final ModelMapper modelMapper;

    public EmployeeRoleDTO toDto(EmployeeRole employeeRole){
        return modelMapper.map(employeeRole, EmployeeRoleDTO.class);
    }

    public EmployeeRole toEntity(EmployeeRoleDTO employeeRoleDTO) {
        return modelMapper.map(employeeRoleDTO, EmployeeRole.class);
    }
}
