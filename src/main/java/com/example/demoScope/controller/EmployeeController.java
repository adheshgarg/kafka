package com.example.demoScope.controller;

import com.example.demoScope.dto.EmployeeDTO;
import com.example.demoScope.entity.Employee;
import com.example.demoScope.service.impl.ProducerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@GetMapping("/employee")
public class EmployeeController {

    @Autowired
    private ProducerService producerService;

    @PostMapping(value="/sup")
    public ResponseEntity<String> addOrUpdate(@RequestBody EmployeeDTO employeeDTO)
    {
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        Employee employeeCreated=producerService.saveIt(employee); //FUNC KA NAAM DAAL DIYO

        return new ResponseEntity<String>(String.valueOf(employeeCreated.getEmpId()),HttpStatus.CREATED);
    }

}
