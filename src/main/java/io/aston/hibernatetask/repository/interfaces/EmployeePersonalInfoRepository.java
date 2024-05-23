package io.aston.hibernatetask.repository.interfaces;

import io.aston.hibernatetask.dto.employeepersonalinfo.EmployeePersonalInfoDTO;
import io.aston.hibernatetask.entity.EmployeePersonalInfo;

public interface EmployeePersonalInfoRepository {
    EmployeePersonalInfo getById(Long id);

    EmployeePersonalInfo save(EmployeePersonalInfoDTO employeePersonalInfoDTO);

    EmployeePersonalInfo update(EmployeePersonalInfo employeePersonalInfo);

    EmployeePersonalInfo delete(EmployeePersonalInfo employeePersonalInfo);
}
