package com.pankajdets.monitoringApplicationUsingGrafana.service;

import com.pankajdets.monitoringApplicationUsingGrafana.controller.EmployeeController;
import com.pankajdets.monitoringApplicationUsingGrafana.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    Map<String, Employee> employeeMap = new HashMap<>();

    public Employee getEmployeeById(String id){
        log.info("Entered into getEmployeeById method with id {}"+id);
        return employeeMap.get(id);

    }

    public List<Employee> getAllEmployee(){
        log.info("Entered into getAllEmployee()");
        ArrayList<Employee> employeeList = new ArrayList<>();
        for(String id: employeeMap.keySet())
            employeeList.add(employeeMap.get(id));
        return  employeeList;
    }

    public String addEmployee(Employee employee){
        log.info("Entered into addEmployee() for employee ID {}"+employee.getEmployeeId());
        employeeMap.put(employee.getEmployeeId(), employee);
        return "Employee Added successfully";
    }

    public Employee updateEmployee(Employee employee){
        log.info("Entered into updateEmployee() for employee ID {} "+employee.getEmployeeId());
        employeeMap.remove(employee.getEmployeeId());
        employeeMap.put(employee.getEmployeeId(), employee);
        return employeeMap.get(employee.getEmployeeId());
    }

    public String deleteEmployeeById(String id){
        log.info("Entered into deleteEmployeeById() for employee Id {} "+ id);
        employeeMap.remove(id);
        return "Employee Deleted Successfully";
    }
}
