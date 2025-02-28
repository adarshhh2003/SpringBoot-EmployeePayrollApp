package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    private List<EmployeePayrollData> empPayrollList = new ArrayList<>();

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return empPayrollList;
    }

    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return empPayrollList.stream()
                .filter(emp -> emp.getEmployeeId()==empId)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with Id " + empId + " not found"));
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empPayrollDTO);
        log.debug("Emp Data: ", empData.toString());
        empPayrollList.add(empData);
        return employeePayrollRepository.save(empData);
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
