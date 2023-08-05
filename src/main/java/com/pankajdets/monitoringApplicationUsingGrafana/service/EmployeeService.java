package com.pankajdets.monitoringApplicationUsingGrafana.service;

import com.pankajdets.monitoringApplicationUsingGrafana.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    Map<String, Employee> employeeMap = new HashMap<>();

    public Employee getEmployeeById(String id){
        return employeeMap.get(id);
    }

    public List<Employee> getAllEmployee(){
        ArrayList<Employee> employeeList = new ArrayList<>();
        for(String id: employeeMap.keySet())
            employeeList.add(employeeMap.get(id));
        return  employeeList;
    }

    public String addEmployee(Employee employee){
        employeeMap.put(employee.getEmployeeId(), employee);
        return "Employee Added successfully";
    }

    public Employee updateEmployee(Employee employee){
        employeeMap.remove(employee.getEmployeeId());
        employeeMap.put(employee.getEmployeeId(), employee);
        return employeeMap.get(employee.getEmployeeId());
    }

    public String deleteEmployeeById(String id){
        employeeMap.remove(id);
        return "Employee Deleted Successfully";
    }
}
