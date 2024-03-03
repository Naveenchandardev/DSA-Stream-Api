package com.practice.dsa.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("banana", "apple", "orange", "kiwi", "grape");
        sort_by_length(strings);
        sort_by_name(strings);
    }

    private static void sort_by_name(List<String> strings) {
        strings.stream().sorted().forEach(System.out::println);
    }
    private static void sort_by_length(List<String> strings) {
        strings.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
    }
}
