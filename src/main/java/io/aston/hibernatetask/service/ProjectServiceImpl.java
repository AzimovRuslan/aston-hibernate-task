package io.aston.hibernatetask.service;

import io.aston.hibernatetask.dto.project.AddOrDeleteEmployeeRequest;
import io.aston.hibernatetask.dto.project.ProjectDTO;
import io.aston.hibernatetask.entity.Employee;
import io.aston.hibernatetask.entity.Project;
import io.aston.hibernatetask.exception.NoSuchEmployeeException;
import io.aston.hibernatetask.repository.interfaces.ProjectRepository;
import io.aston.hibernatetask.service.interfaces.EmployeeService;
import io.aston.hibernatetask.service.interfaces.ProjectService;
import io.aston.hibernatetask.utility.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final EmployeeService employeeService;

    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getById(id);
    }

    @Override
    public Project save(ProjectDTO projectDTO) {
        return projectRepository.save(projectDTO);
    }

    @Override
    public Project update(Project project) {
        return projectRepository.update(project);
    }

    @Override
    public Project delete(Project project) {
        return projectRepository.delete(project);
    }

    @Override
    public Project addEmployee(AddOrDeleteEmployeeRequest request) {
        Project project = getById(request.getProjectId());

        Employee employee = employeeService.getById(request.getEmployeeId());
        project.getEmployees().add(employee);

        return update(project);
    }

    @Override
    public Project deleteEmployee(AddOrDeleteEmployeeRequest request) {
        Project project = getById(request.getProjectId());

        Employee employeeForDelete = project.getEmployees().stream()
                .filter(e -> Objects.equals(e.getId(), request.getEmployeeId()))
                .findFirst()
                .orElse(null);

        if (employeeForDelete != null) {
            project.getEmployees().remove(employeeForDelete);
        } else {
            throw new NoSuchEmployeeException(Constants.NO_SUCH_EMPLOYEE);
        }

        return update(project);
    }
}
