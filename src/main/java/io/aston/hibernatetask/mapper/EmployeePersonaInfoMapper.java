package io.aston.hibernatetask.mapper;

import io.aston.hibernatetask.dto.employeepersonalinfo.EmployeePersonalInfoDTO;
import io.aston.hibernatetask.entity.EmployeePersonalInfo;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Data
public class EmployeePersonaInfoMapper implements IMapper<EmployeePersonalInfo, EmployeePersonalInfoDTO>{

    private final ModelMapper modelMapper;

    @Override
    public EmployeePersonalInfoDTO toDto(EmployeePersonalInfo employeePersonalInfo){
        return modelMapper.map(employeePersonalInfo, EmployeePersonalInfoDTO.class);
    }

    @Override
    public EmployeePersonalInfo toEntity(EmployeePersonalInfoDTO employeePersonalInfoDTO){
        return modelMapper.map(employeePersonalInfoDTO, EmployeePersonalInfo.class);
    }
}
