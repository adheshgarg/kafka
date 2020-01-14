package com.example.demoScope.repository;

import com.example.demoScope.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePostgresRepository extends CrudRepository<Employee,String> {
}
