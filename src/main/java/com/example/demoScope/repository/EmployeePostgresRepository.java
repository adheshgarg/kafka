package com.example.demoScope.repository;

import com.example.demoScope.entity.EmployeePostgres;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "EmployeePostgresRepository")
public interface EmployeePostgresRepository extends CrudRepository<EmployeePostgres,String> {
}
