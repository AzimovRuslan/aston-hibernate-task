package io.aston.hibernatetask.mapper;

import io.aston.hibernatetask.dto.project.ProjectDTO;
import io.aston.hibernatetask.entity.Project;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProjectMapper implements IMapper<Project, ProjectDTO> {

    private final ModelMapper modelMapper;

    @Override
    public Project toEntity(ProjectDTO projectDTO) {
        return modelMapper.map(projectDTO, Project.class);
    }

    @Override
    public ProjectDTO toDto(Project project) {
        return modelMapper.map(project, ProjectDTO.class);
    }
}
