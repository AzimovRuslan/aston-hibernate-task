package io.aston.hibernatetask.repository;

import io.aston.hibernatetask.dto.project.ProjectDTO;
import io.aston.hibernatetask.entity.Project;
import io.aston.hibernatetask.mapper.ProjectMapper;
import io.aston.hibernatetask.repository.interfaces.ProjectRepository;
import io.aston.hibernatetask.utility.HibernateSessionFactoryUtil;
import lombok.Data;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class ProjectRepositoryImpl implements ProjectRepository {

    private final ProjectMapper projectMapper;

    @Override
    public List<Project> getAll() {
        try(Session session = HibernateSessionFactoryUtil.getSession()) {
            return session.createQuery("from Project ", Project.class).list();
        }
    }

    @Override
    public Project getById(Long id) {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            return session.get(Project.class, id);
        }
    }

    @Override
    public Project save(ProjectDTO projectDTO) {
        try(Session session = HibernateSessionFactoryUtil.getSession()) {

            Project project = projectMapper.toEntity(projectDTO);
            session.beginTransaction();
            session.save(project);
            session.getTransaction().commit();

            return project;
        }
    }

    @Override
    public Project update(Project project) {

        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.update(project);
            session.getTransaction().commit();
        }

        return project;
    }

    @Override
    public Project delete(Project project) {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.delete(project);
            session.getTransaction().commit();
        }

        return project;
    }
}
