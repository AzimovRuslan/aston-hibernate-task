package io.aston.hibernatetask;

import io.aston.hibernatetask.mapper.EmployeeRoleMapper;
import io.aston.hibernatetask.repository.EmployeeRoleRepositoryImpl;
import io.aston.hibernatetask.repository.interfaces.EmployeeRoleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateTaskApplication.class, args);
    }

}
