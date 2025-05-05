package com.pluralsight;

import java.util.UUID;

public class Employee {
    private UUID employeeId;
    private String name, department;
    private float payRate, hoursWorked;

    public Employee(UUID employeeId, String name, String department, float payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0; //when starting a job you always start with 0 hrs
    }

    //Gets
    float getTotalPay(){
        return getRegularHours() * payRate + getOvertimeHours() * payRate * 1.5f;
    }
    float getRegularHours(){
        return Math.min(40f, hoursWorked);
    }
    float getOvertimeHours(){
        return Math.min(0, hoursWorked - 40);
    }
    public UUID getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    //Sets
    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    public void incrementHoursWorked(float additionalHours){
        this.hoursWorked += additionalHours;
    }

}
