package com.practice.dsa.stream.Basics;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "John", "Ravi", "Krish", "Sam");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        groupByLength(names);
        groupByEvenOdd(numbers);
    }

    private static void groupByEvenOdd(List<Integer> numbers) {
        Map<String, List<Integer>> result =
                numbers.stream()
                        .collect(Collectors.groupingBy(
                                n -> n % 2 == 0 ? "Even" : "Odd"
                        ));

        System.out.println(result);
    }

    private static void groupByLength(List<String> names) {
        Map<Integer, List<String>> result = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(result);
    }
}
