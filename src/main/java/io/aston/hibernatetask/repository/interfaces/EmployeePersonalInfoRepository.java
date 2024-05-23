package io.aston.hibernatetask.repository.interfaces;

import io.aston.hibernatetask.dto.employeepersonalinfo.EmployeePersonalInfoDTO;
import io.aston.hibernatetask.entity.EmployeePersonalInfo;

import java.util.List;

public interface EmployeePersonalInfoRepository {
    List<EmployeePersonalInfo> getAll();

    EmployeePersonalInfo getById(Long id);

    EmployeePersonalInfo save(EmployeePersonalInfoDTO employeePersonalInfoDTO);

    EmployeePersonalInfo update(EmployeePersonalInfo employeePersonalInfo);

    EmployeePersonalInfo delete(EmployeePersonalInfo employeePersonalInfo);
}
