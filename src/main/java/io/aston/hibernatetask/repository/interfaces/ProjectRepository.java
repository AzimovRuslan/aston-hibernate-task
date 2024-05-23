package io.aston.hibernatetask.repository.interfaces;

import io.aston.hibernatetask.dto.employeerole.EmployeeRoleDTO;
import io.aston.hibernatetask.dto.project.ProjectDTO;
import io.aston.hibernatetask.entity.EmployeeRole;
import io.aston.hibernatetask.entity.Project;

import java.util.List;

public interface ProjectRepository {
    List<Project> getAll();

    Project getById(Long id);

    Project save(ProjectDTO projectDTO);

    Project update(Project project);

    Project delete(Project project);
}
