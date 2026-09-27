package com.practice.dsa.stream.entity;

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
                new Employee2("Chandar", 4000, "male","Software"),
                new Employee2("Thiru", 5000, "male","Developer"),
                new Employee2("Prem", 35000, "male","BPO"),
                new Employee2("Mano", 60000, "Female","Software"),
                new Employee2("Shankar", 15000, "male","BPO"),
                new Employee2("Sathish", 70000, "Female","SAP"),
                new Employee2("Ramya", 25000, "Female","BPO"));
        System.out.println("---------------------------------------");
        //print only male candidates
        System.out.println("Print male employees only :: ");
        employees.stream().filter(x-> Objects.equals(x.getGender(), "male")).forEach(System.out::println);
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

        Map<String, Optional<Employee2>> highestPaidMFEmployee = employees.stream().collect(
                Collectors.groupingBy(Employee2::getDepartment,
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

        System.out.println("Print by names;");
        List<Employee2> empName = employees.stream().sorted(Comparator.comparing(Employee2::getName)).toList();
        empName.forEach(System.out::println);
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

        Map<String, List<Employee2>> groupbyDepartment = employees.stream().collect(groupingBy(Employee2::getDepartment));
        System.out.println("groupbyDepartment :" + groupbyDepartment);
        System.out.println("---------------------------------------");

        Map<String, Optional<Employee2>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee2::getDepartment,
                        Collectors.maxBy(
                                Comparator.comparing(Employee2::getSalary)
                        )
                ));

        result.forEach((department, employee) ->
                System.out.println(department + " → " + employee.get()));
        System.out.println("Highest salary employee details by department : "+result);
        System.out.println("---------------------------------------");


        Map<String, Integer> highSalaryByDep = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee2::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee2::getSalary))
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().get().getSalary()
                ));        System.out.println("Highest salary by department : "+highSalaryByDep);
        System.out.println("---------------------------------------");


        Map<String,Integer> employCount = employees.stream().collect(groupingBy(Employee2::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(), List::size)));

        System.out.println("Employee counts by department : "+ employCount);
        System.out.println("---------------------------------------");


        List<Employee2> sorted = employees.stream().sorted(Comparator.comparing(Employee2::getDepartment)
                .thenComparing(Employee2::getSalary)).toList();
        System.out.println(sorted);
        System.out.println("---------------------------------------");


        Map<String, Long> morethan = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee2::getDepartment,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 2)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

        System.out.println( "departments having more than 2 employees : "+morethan);
        System.out.println("---------------------------------------");


        Map<String, Double> total = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee2::getDepartment,
                        Collectors.summingDouble(Employee2::getSalary)
                ));

        System.out.println(total);
        System.out.println("---------------------------------------");

        Employee2 longestName = employees.stream()
                .max(Comparator.comparingInt(e -> e.getName().length()))
                .orElse(null);

        System.out.println(longestName);
        System.out.println("---------------------------------------");

        List<Employee2> top3 = employees.stream()
                .sorted(Comparator.comparing(Employee2::getSalary).reversed())
                .limit(3)
                .toList();

        top3.forEach(System.out::println);
        System.out.println("---------------------------------------");

        Map<String, List<Employee2>> grouped = employees.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment));

        grouped.forEach((department, list) -> {

            Employee2 secondHighest = list.stream()
                    .sorted(Comparator.comparing(Employee2::getSalary).reversed())
                    .skip(1)
                    .findFirst()
                    .orElse(null);

            System.out.println(department + " → " + secondHighest);
        });
        System.out.println("---------------------------------------");

        Map<String, List<Employee2>> limit2ByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment));

        limit2ByDept.forEach((department, list) -> {

            List<Employee2> top2 = list.stream()
                    .sorted(Comparator.comparing(Employee2::getSalary).reversed())
                    .limit(2)
                    .toList();

            System.out.println(department + " → " + top2);
        });
        System.out.println("---------------------------------------");


        Map<String, Long> countByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee2::getDepartment,
                        Collectors.counting()
                ));

        Map.Entry<String, Long> maxEmployee = countByDepartment.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println(maxEmployee);
        System.out.println("---------------------------------------");





    }
}
