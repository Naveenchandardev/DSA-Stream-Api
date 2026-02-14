package com.practice.dsa.stream.Basics;

import java.util.Map;
import java.util.stream.Collectors;

public class CountCharacters {
    public static void main(String[] args) {
        String input = "programming";
        Map<Character, Long> result =
                input.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                c -> c,
                                Collectors.counting()
                        ));

        System.out.println(result);
    }
}
