package com.practice.dsa.stream;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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
                new Employee2("Sathish", 70000, "Female","SAP"),
                new Employee2("Ramya", 25000, "Female","BPO"));
        System.out.println("---------------------------------------");
        //print only male candidates
        System.out.println("Print male employees only :: ");
        employees.stream().filter(x->x.getGender()=="male").forEach(System.out::println);
        System.out.println("---------------------------------------");

        // print : group by gender and count
        System.out.println("Print no of male and female");
        Map<String,Long> res = employees.stream().collect(groupingBy(Employee2::getGender,Collectors.counting()));
        System.out.println(res);
        System.out.println("---------------------------------------");

        //Print Average age of Male and Female Employees
        Map<String, Double> avgAge = employees.stream().collect(Collectors.groupingBy
                (Employee2::getGender,Collectors.averagingInt(Employee2::getSalary)));
        System.out.println("Average salary of Male and Female Employees:: " + avgAge);
        System.out.println("---------------------------------------");

        System.out.println("print highest salary based on department");
        Map<String, Optional<Employee2>> highestPaidMFEmployee = employees.stream().collect(Collectors.groupingBy(Employee2::getDepartment,
                Collectors.maxBy(Comparator.comparingInt(Employee2::getSalary))));
        System.out.println("Highest paid  employee based on department is : " + highestPaidMFEmployee);
        System.out.println("---------------------------------------");

        //find highest salary person:
        Optional<Employee2> highestsarlary= employees.stream().max(Comparator.comparingDouble(Employee2::getSalary));
        highestsarlary.ifPresent(x-> System.out.println("Highest salary person is:: "+x.getName()+" and  salary is :: "+x.getSalary()));
        System.out.println("---------------------------------------");

        // find highest 2nd salary ;
        Optional<Employee2> empHighest = employees.stream().sorted(Comparator.comparingDouble(Employee2::getSalary).reversed())
                .skip(1).findFirst();
        System.out.println("Second Highest Salary in the organisation : " + empHighest.get().getSalary());
        System.out.println("---------------------------------------");

        // find highest salary only
        double highestsalary2= employees.stream().mapToDouble(Employee2::getSalary).max().getAsDouble();
        System.out.println("Overall highest salary :: "+highestsalary2);
        System.out.println("---------------------------------------");
        // Print employees grouped by department
        System.out.println("Print employees based on department");
        Map<String,List<Employee2>> groupBy = employees.stream().collect(groupingBy(Employee2::getDepartment));
        groupBy.forEach((department, empList) -> {
            System.out.println("Department: " + department);
            empList.forEach(emp ->  System.out.println("    " + emp.getName() + " (Salary: " + emp.getSalary() + ")"));
        });
        System.out.println("---------------------------------------");
    }
}
