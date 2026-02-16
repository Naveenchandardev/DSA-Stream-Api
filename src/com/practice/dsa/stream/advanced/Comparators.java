package com.practice.dsa.stream.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;


public class Comparators {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "Ravi", "Christopher");

        Optional<String> longest =
                names.stream()
                        .max(Comparator.comparing(String::length));

        System.out.println(longest);
    }
}
