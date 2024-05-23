package io.aston.hibernatetask.controller;

import io.aston.hibernatetask.dto.project.AddOrDeleteEmployeeRequest;
import io.aston.hibernatetask.dto.project.ProjectDTO;
import io.aston.hibernatetask.entity.Project;
import io.aston.hibernatetask.exception.IncorrectInputException;
import io.aston.hibernatetask.service.interfaces.ProjectService;
import io.aston.hibernatetask.utility.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/projects")
@AllArgsConstructor
@Slf4j
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Project getById(@PathVariable("id") Long id) {
        Project project = projectService.getById(id);

        if (project == null) {
            log.error(Constants.INCORRECT_ID + Constants.REQUEST_FAILED);
            throw new IncorrectInputException(Constants.INCORRECT_ID);

        }

        log.info(Constants.PROJECT + Constants.FOUND + Constants.WITH_ID + id);
        return project;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project save(@RequestBody ProjectDTO projectDTO) {
        Project project = projectService.save(projectDTO);
        log.info(Constants.PROJECT + Constants.SUCCESSFUL_SAVE + project);
        return project;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project update(@RequestBody Project project) {
        Project updatedProject = projectService.update(project);
        log.info(Constants.PROJECT + Constants.SUCCESSFUL_UPDATE);
        return updatedProject;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Project delete(@RequestBody Project project) {
        Project deletedProject = projectService.delete(project);
        log.info(Constants.PROJECT + Constants.SUCCESSFUL_DELETE);
        return deletedProject;
    }

    @PostMapping("/add-employee-to-project")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Project addEmployee(@RequestBody AddOrDeleteEmployeeRequest request) {
        Project project = projectService.addEmployee(request);
        log.info(Constants.EMPLOYEE + Constants.SUCCESSFUL_ADDED + Constants.PROJECT + project);
        return project;
    }

    @PostMapping("/delete-employee-from-project")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Project deleteEmployee(@RequestBody AddOrDeleteEmployeeRequest request) {
        Project project = projectService.deleteEmployee(request);
        log.info(Constants.EMPLOYEE + Constants.SUCCESSFUL_DELETE + Constants.PROJECT + project);
        return project;
    }
}
