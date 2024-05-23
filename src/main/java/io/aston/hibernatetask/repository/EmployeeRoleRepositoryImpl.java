package io.aston.hibernatetask.repository;

import io.aston.hibernatetask.dto.employeerole.EmployeeRoleDTO;
import io.aston.hibernatetask.entity.EmployeeRole;
import io.aston.hibernatetask.mapper.EmployeeRoleMapper;
import io.aston.hibernatetask.repository.interfaces.EmployeeRoleRepository;
import io.aston.hibernatetask.utility.HibernateSessionFactoryUtil;
import lombok.Data;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class EmployeeRoleRepositoryImpl implements EmployeeRoleRepository {

    private final EmployeeRoleMapper employeeRoleMapper;

    @Override
    public EmployeeRole getById(Long id) {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            return session.get(EmployeeRole.class, id);
        }
    }

    @Override
    public EmployeeRole save(EmployeeRoleDTO employeeRoleDTO) {
        try(Session session = HibernateSessionFactoryUtil.getSession()) {

            EmployeeRole employeeRole = employeeRoleMapper.toEntity(employeeRoleDTO);
            session.beginTransaction();
            session.save(employeeRole);
            session.getTransaction().commit();

            return employeeRole;
        }
    }

    @Override
    public EmployeeRole update(EmployeeRole employeeRole) {

        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.update(employeeRole);
            session.getTransaction().commit();
        }

        return employeeRole;
    }

    @Override
    public EmployeeRole delete(EmployeeRole employeeRole) {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.delete(employeeRole);
            session.getTransaction().commit();
        }

        return employeeRole;
    }
}
