package io.aston.hibernatetask.mapper;

import io.aston.hibernatetask.dto.employeerole.EmployeeRoleDTO;
import io.aston.hibernatetask.entity.EmployeeRole;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Data
public class EmployeeRoleMapper implements IMapper<EmployeeRole, EmployeeRoleDTO>{
    private final ModelMapper modelMapper;

    @Override
    public EmployeeRoleDTO toDto(EmployeeRole employeeRole){
        return modelMapper.map(employeeRole, EmployeeRoleDTO.class);
    }

    @Override
    public EmployeeRole toEntity(EmployeeRoleDTO employeeRoleDTO) {
        return modelMapper.map(employeeRoleDTO, EmployeeRole.class);
    }
}
