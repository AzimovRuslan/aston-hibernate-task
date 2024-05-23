package io.aston.hibernatetask.service.interfaces;

import io.aston.hibernatetask.dto.project.AddOrDeleteEmployeeRequest;
import io.aston.hibernatetask.dto.project.ProjectDTO;
import io.aston.hibernatetask.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();

    Project getById(Long id);

    Project save(ProjectDTO projectDTO);

    Project update(Project project);

    Project delete(Project project);

    Project addEmployee(AddOrDeleteEmployeeRequest request);

    Project deleteEmployee(AddOrDeleteEmployeeRequest request);
}
