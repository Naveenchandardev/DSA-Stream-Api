package com.practice.dsa.stream.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Naveen", 85),
                new Student("Raj", 40),
                new Student("Arun", 30),
                new Student("Kumar", 75)
        );

        Map<Boolean, List<Student>> result =
                students.stream()
                        .collect(
                                Collectors.partitioningBy(s -> s.getMarks() >= 50)
                        );

        //Count how many passed and failed:
        Map<Boolean, Long> result2 =
                students.stream()
                        .collect(
                                Collectors.partitioningBy(s -> s.getMarks() >= 50, Collectors.counting()
                        ));

        System.out.println(result);
        System.out.println(result2);
    }
}
