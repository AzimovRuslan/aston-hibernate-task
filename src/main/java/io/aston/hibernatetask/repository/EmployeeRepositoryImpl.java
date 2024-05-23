package io.aston.hibernatetask.repository;

import io.aston.hibernatetask.dto.employee.EmployeeCreateRequest;
import io.aston.hibernatetask.entity.Employee;
import io.aston.hibernatetask.mapper.EmployeeMapper;
import io.aston.hibernatetask.repository.interfaces.EmployeeRepository;
import io.aston.hibernatetask.utility.HibernateSessionFactoryUtil;
import lombok.Data;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAll() {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            return session.createQuery("from Employee", Employee.class).list();
        }
    }

    @Override
    public Employee getById(Long id) {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public Employee save(EmployeeCreateRequest employeeCreateRequest) {
        try(Session session = HibernateSessionFactoryUtil.getSession()) {

            Employee employee = employeeMapper.employeeCreateRequestToEntity(employeeCreateRequest);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            return employee;
        }
    }

    @Override
    public Employee update(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();

            return employee;
        }
    }

    @Override
    public Employee delete(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
        }

        return employee;
    }
}
