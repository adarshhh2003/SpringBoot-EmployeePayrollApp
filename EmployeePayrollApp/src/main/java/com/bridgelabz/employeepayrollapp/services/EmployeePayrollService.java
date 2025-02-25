package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    private List<EmployeePayrollData> empPayrollList = new ArrayList<>();

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return empPayrollList;
    }

    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return empPayrollList.get(empId-1);
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empPayrollList.size()+1, empPayrollDTO);
        empPayrollList.add(empData);
        return empData;
    }

    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.setName(employeePayrollDTO.name);
        empData.setSalary(employeePayrollDTO.salary);
        empPayrollList.set(empId-1, empData);
        return empData;
    }

    public void deleteEmployeePayrollData(int empId) {
        empPayrollList.remove(empId-1);
    }
}
