package com.practice.dsa.stream.advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstNonRepeatingInteger {
    public static void main(String[] args) {
        String input = "swiss";
        Optional<Character> result =
                input.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                c -> c,
                                LinkedHashMap::new,
                                Collectors.counting()
                        ))
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .findFirst();

        System.out.println(result.orElse(null));
    }
}
