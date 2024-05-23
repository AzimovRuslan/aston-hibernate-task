package io.aston.hibernatetask.repository;

import io.aston.hibernatetask.dto.employeerole.EmployeeRoleDTO;
import io.aston.hibernatetask.entity.EmployeeRole;
import io.aston.hibernatetask.mapper.EmployeeRoleMapper;
import io.aston.hibernatetask.repository.interfaces.EmployeeRoleRepository;
import io.aston.hibernatetask.utility.HibernateSessionFactoryUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class EmployeeRoleRepositoryImpl implements EmployeeRoleRepository {

    @Autowired
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
}
