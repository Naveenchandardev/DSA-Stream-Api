package com.practice.dsa.stream.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employees [name=" + name + ", salary=" + salary + "]";
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public static void main(String[] args) {
	    List<Employee> employees = Arrays.asList(
				//when users salary was equal; then compare with names and print;
	    	    new Employee("Shanmugam", 12000),
	    	    new Employee("Sathish", 10000), 
                new Employee("Thiru", 10000),
                new Employee("Prem", 12000),
                new Employee("Prem", 11000),
                new Employee("Chandar", 15000));
                
    List<Employee> filteredEmployees = employees.stream()
            .filter(employee -> employee.getSalary() >= 10000)
            .sorted((e1, e2) -> {
                if (e1.getSalary() == e2.getSalary()) {
                    return e1.getName().compareTo(e2.getName());
                }
                return Double.compare(e2.getSalary(), e1.getSalary());
            })
            .collect(Collectors.toList());

    System.out.println("Filtered and Sorted Employees:");
    filteredEmployees.forEach(System.out::println);
	}

}
