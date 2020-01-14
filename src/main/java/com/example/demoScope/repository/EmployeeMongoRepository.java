package com.example.demoScope.repository;

import com.example.demoScope.entity.EmployeeMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "EmployeeMongoRepository")
public interface EmployeeMongoRepository extends MongoRepository<EmployeeMongo,String> {
}
