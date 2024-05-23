package io.aston.hibernatetask.controller;

import io.aston.hibernatetask.dto.employeepersonalinfo.EmployeePersonalInfoDTO;
import io.aston.hibernatetask.entity.EmployeePersonalInfo;
import io.aston.hibernatetask.exception.IncorrectInputException;
import io.aston.hibernatetask.service.interfaces.EmployeePersonalInfoService;
import io.aston.hibernatetask.utility.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v0/employees-personal-info")
@AllArgsConstructor
@Slf4j
public class EmployeePersonalInfoController {


    private final EmployeePersonalInfoService employeePersonalInfoService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public EmployeePersonalInfo getById(@PathVariable("id") Long id) {
        EmployeePersonalInfo employeePersonalInfo = employeePersonalInfoService.getById(id);

        if (employeePersonalInfo == null) {
            log.error(Constants.INCORRECT_ID + Constants.REQUEST_FAILED);
            throw new IncorrectInputException(Constants.INCORRECT_ID);
        }

        log.info(Constants.EMPLOYEE_PERSONAL_INFO + Constants.FOUND + Constants.WITH_ID + id);
        return employeePersonalInfo;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeePersonalInfo save(@RequestBody EmployeePersonalInfoDTO employeePersonalInfoDTO) {
        EmployeePersonalInfo employeePersonalInfo = employeePersonalInfoService.save(employeePersonalInfoDTO);
        log.info(Constants.EMPLOYEE_PERSONAL_INFO + Constants.SUCCESSFUL_SAVE + employeePersonalInfo);
        return employeePersonalInfo;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeePersonalInfo update(@RequestBody EmployeePersonalInfo employeePersonalInfo) {
        EmployeePersonalInfo updatedPersonalInfo = employeePersonalInfoService.update(employeePersonalInfo);
        log.info(Constants.EMPLOYEE_PERSONAL_INFO + Constants.SUCCESSFUL_UPDATE);
        return updatedPersonalInfo;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EmployeePersonalInfo delete(@RequestBody EmployeePersonalInfo EmployeePersonalInfo) {
        EmployeePersonalInfo deletedPersonalInfo = employeePersonalInfoService.delete(EmployeePersonalInfo);
        log.info(Constants.EMPLOYEE_PERSONAL_INFO + Constants.SUCCESSFUL_DELETE);
        return deletedPersonalInfo;
    }
}
