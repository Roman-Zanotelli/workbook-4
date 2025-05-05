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
    public LocalDateTime punchIn(){ //returns null if already punched in
        if(punchIn != null) return null; //check if their already punched in
        punchIn = LocalDateTime.now(); //if not punch them in
        return punchIn; //return punch in time
    }

    public Object[] punchOut(){ //returns null if not punched in
        //check if they are already punched out
        if(punchIn == null) return null;

        //get punchout time
        LocalDateTime punchOut = LocalDateTime.now();

        //calc time diff
        float diff = punchIn.until(punchOut, ChronoUnit.HOURS);
        incrementHoursWorked(diff); //increment by diff

        //generate time card
        Object[] timecard = new Object[]{punchIn, punchOut, diff};

        //set employee as punched out
        punchIn = null;

        //return final timecard
        return timecard;
    }
    public Object[] punchTimeCard(LocalDateTime in, LocalDateTime out){
        float diff = in.until(out, ChronoUnit.HOURS);
        incrementHoursWorked(diff);
        return new Object[]{ in, out, diff};
    }


    //Example using double instead of LocalDateTime (definitely not preferred)
//    private Double punchInDouble; //using Double wrapper better indicate punched out status
//    public Double punchIn(double in){ //returns null if already punched in
//        if(punchInDouble != null) return null; //check if the employee is already punched out
//        this.punchInDouble = in; //punch them in if not
//        return punchInDouble; //return punch in time
//    }
//    public double[] punchOut(double out){ //returns null if not punched in
//        if(punchInDouble == null) return null; //return null if not punched in
//        double diff = out - punchInDouble; //calc time diff
//        incrementHoursWorked(diff); //increment by diff
//        double[] timecard = new double[]{punchInDouble, out, diff}; //generate timecard
//        punchInDouble = null; //indicate employee is punched out
//        return timecard; //return time card
//    }
//    public double punchTimeCard(double in, double out){
//        double diff = out - in;
//        incrementHoursWorked(diff);
//        return diff;
//    }

}
