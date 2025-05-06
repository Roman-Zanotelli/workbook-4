package com.pluralsight;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Employee {
    private UUID employeeId;
    private String name, department;
    private double payRate, hoursWorked;
    private LocalDateTime punchIn;

    public Employee(UUID employeeId, String name, String department, float payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0; //when starting a job you always start with 0 hrs
    }

    //Gets
     double getTotalPay(){
        return getRegularHours() * payRate + getOvertimeHours() * payRate * 1.5f;
    }
    double getRegularHours(){
        return Math.min(40f, hoursWorked);
    }
    double getOvertimeHours(){
        return Math.max(0, hoursWorked - 40);
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
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void incrementHoursWorked(double additionalHours){
        this.hoursWorked += additionalHours;
    }

    //Methods
    //returns null if already punched in
    public LocalDateTime punchIn(){
        //check if their already punched in
        if(this.punchIn != null) return null;

        //if not punch them in
        this.punchIn = LocalDateTime.now();
        
        //return punch in time
        return this.punchIn;
    }

    //returns null if already punched in
    public LocalDateTime punchIn(LocalDateTime punchIn){
        //check if their already punched in
        if(this.punchIn != null) return null;

        //if not punch them in
        this.punchIn = punchIn;

        //return punch in time
        return this.punchIn;
    }

    //returns null if not punched in
    public Object[] punchOut(){
        //check if they are already punched out
        if(this.punchIn == null) return null;

        //get punchout time
        LocalDateTime punchOut = LocalDateTime.now();

        //calc time diff
        float diff = this.punchIn.until(punchOut, ChronoUnit.HOURS);
        incrementHoursWorked(diff); //increment by diff

        //generate time card
        Object[] timecard = new Object[]{this.punchIn, punchOut, diff};

        //set employee as punched out
        this.punchIn = null;

        //return final timecard
        return timecard;
    }

    //returns null if not punched in
    public Object[] punchOut(LocalDateTime punchOut){
        //check if they are already punched out
        if(this.punchIn == null) return null;

        //calc time diff
        float diff = this.punchIn.until(punchOut, ChronoUnit.HOURS);
        incrementHoursWorked(diff); //increment by diff

        //generate time card
        Object[] timecard = new Object[]{this.punchIn, punchOut, diff};

        //set employee as punched out
        this.punchIn = null;

        //return final timecard
        return timecard;
    }

    public Object[] punchTimeCard(LocalDateTime in, LocalDateTime out){
        float diff = in.until(out, ChronoUnit.HOURS);
        incrementHoursWorked(diff);
        return new Object[]{ in, out, diff};
    }



}
