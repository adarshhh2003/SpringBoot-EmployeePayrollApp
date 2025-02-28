package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Name Invalid")
    public String name;

    @Min(value = 500, message = "Min wage should be more than 500")
    public long salary;

    @Pattern(regexp = "male|female", message = "Gender needs to male or female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "StartDate should not be null")
    @PastOrPresent(message = "StartDate should be past or today's date")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    public String note;

    @NotBlank(message = "ProfilePic cannot be Empty")
    public String profilePic;

    @NotNull(message = "Department should not be Empty")
    public List<String> department;
}
