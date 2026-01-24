package com.practice.dsa.stream.Basics;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurence {
    public static void main(String[] args) {
        //find fruits count; using grouping by; groupingBy(Object, count);
        List<String> list = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String,Long> result = list.stream().collect(Collectors.groupingBy(n->n, Collectors.counting()));
        System.out.println(result);
    }
}
