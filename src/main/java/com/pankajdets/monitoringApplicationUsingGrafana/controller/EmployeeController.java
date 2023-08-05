package com.pankajdets.monitoringApplicationUsingGrafana.controller;

import com.pankajdets.monitoringApplicationUsingGrafana.entity.Employee;
import com.pankajdets.monitoringApplicationUsingGrafana.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck(){
        log.info("Entered into Health Check Controller");
        log.debug("Entered into Health Check Controller");
        log.trace("Entered into Health Check Controller");
        return new ResponseEntity<>( "Application is Up and Running..", HttpStatus.OK);
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id){
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employeeList = employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);

    }

    @PostMapping("/employee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){

        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);

    }

    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String id){
        return new ResponseEntity<>(employeeService.deleteEmployeeById(id), HttpStatus.OK);
    }





}
