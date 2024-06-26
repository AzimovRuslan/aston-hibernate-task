package io.aston.hibernatetask.repository;

import io.aston.hibernatetask.dto.employeepersonalinfo.EmployeePersonalInfoDTO;
import io.aston.hibernatetask.entity.EmployeePersonalInfo;
import io.aston.hibernatetask.mapper.EmployeePersonaInfoMapper;
import io.aston.hibernatetask.repository.interfaces.EmployeePersonalInfoRepository;
import io.aston.hibernatetask.utility.HibernateSessionFactoryUtil;
import lombok.Data;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class EmployeePersonalInfoRepositoryImpl implements EmployeePersonalInfoRepository {

    private final EmployeePersonaInfoMapper employeePersonaInfoMapper;

    @Override
    public List<EmployeePersonalInfo> getAll() {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            return session.createQuery("from EmployeePersonalInfo", EmployeePersonalInfo.class).list();
        }
    }

    @Override
    public EmployeePersonalInfo getById(Long id) {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            return session.get(EmployeePersonalInfo.class, id);
        }
    }

    @Override
    public EmployeePersonalInfo save(EmployeePersonalInfoDTO employeePersonalInfoDTO) {
        try(Session session = HibernateSessionFactoryUtil.getSession()) {

            EmployeePersonalInfo employeePersonalInfo = employeePersonaInfoMapper.toEntity(employeePersonalInfoDTO);
            session.beginTransaction();
            session.save(employeePersonalInfo);
            session.getTransaction().commit();

            return employeePersonalInfo;
        }
    }

    @Override
    public EmployeePersonalInfo update(EmployeePersonalInfo employeePersonalInfo) {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.update(employeePersonalInfo);
            session.getTransaction().commit();
        }

        return employeePersonalInfo;
    }

    @Override
    public EmployeePersonalInfo delete(EmployeePersonalInfo employeePersonalInfo) {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.delete(employeePersonalInfo);
            session.getTransaction().commit();
        }

        return employeePersonalInfo;
    }
}
