package com.pankajdets.monitoringApplicationUsingGrafana.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String employeeId;
    private String employeeName;
    private String employeeAddress;
    private String employeeSalary;

}
