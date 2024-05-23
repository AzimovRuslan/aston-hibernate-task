package io.aston.hibernatetask.service;

import io.aston.hibernatetask.dto.employeepersonalinfo.EmployeePersonalInfoDTO;
import io.aston.hibernatetask.entity.EmployeePersonalInfo;
import io.aston.hibernatetask.repository.interfaces.EmployeePersonalInfoRepository;
import io.aston.hibernatetask.service.interfaces.EmployeePersonalInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeePersonalInfoServiceImpl implements EmployeePersonalInfoService {

    private final EmployeePersonalInfoRepository employeePersonalInfoRepository;


    @Override
    public List<EmployeePersonalInfo> getAll() {
        return employeePersonalInfoRepository.getAll();
    }

    @Override
    public EmployeePersonalInfo getById(Long id) {
        return employeePersonalInfoRepository.getById(id);
    }

    @Override
    public EmployeePersonalInfo save(EmployeePersonalInfoDTO employeePersonalInfoDTO) {
        return employeePersonalInfoRepository.save(employeePersonalInfoDTO);
    }

    @Override
    public EmployeePersonalInfo update(EmployeePersonalInfo employeePersonalInfo) {
        return employeePersonalInfoRepository.update(employeePersonalInfo);
    }

    @Override
    public EmployeePersonalInfo delete(EmployeePersonalInfo employeePersonalInfo) {
        return employeePersonalInfoRepository.delete(employeePersonalInfo);    }
}
