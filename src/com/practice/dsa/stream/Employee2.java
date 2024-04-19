package com.practice.dsa.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Employee2 {

    private String name;
    private int salary;
    private String gender;
    private String department;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees [name=" + name + ", salary=" + salary + "]";
    }

    public Employee2(String name, int salary, String gender, String department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.department = department;
    }

    public static void main(String[] args) {
        List<Employee2> employees = Arrays.asList(
                new Employee2("Chandar", 4000, "male","software"),
                new Employee2("Thiru", 5000, "male","Plsql"),
                new Employee2("Prem", 35000, "male","BPO"),
                new Employee2("Mano", 60000, "Female","software"),
                new Employee2("Shankar", 15000, "male","BPO"),
                new Employee2("Sathish", 60000, "Female","SAP"),
                new Employee2("Ramya", 25000, "Female","BPO"));

        //print only male candidates
        employees.stream().filter(x->x.getGender()=="male").forEach(System.out::println);

        // print : group by gender and count
        Map<String,Long> res = employees.stream().collect(Collectors.groupingBy(Employee2::getGender,Collectors.counting()));
        System.out.println(res);

        //find highest salary:
        Optional<Employee2> highestsarlary= employees.stream().max(Comparator.comparingDouble(Employee2::getSalary));
        highestsarlary.ifPresent(x-> System.out.println("highest Sarlary is:: "+x.getSalary()));

        // Print employees grouped by department
        Map<String,List<Employee2>> groupBy = employees.stream().collect(Collectors.groupingBy(Employee2::getDepartment));
        groupBy.forEach((department, empList) -> {
            System.out.println("Department: " + department);
            empList.forEach(emp -> System.out.println("    " + emp.getName() + " (Salary: " + emp.getSalary() + ")"));
        });
    }
}
