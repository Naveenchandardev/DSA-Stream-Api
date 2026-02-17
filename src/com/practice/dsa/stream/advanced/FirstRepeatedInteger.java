package com.practice.dsa.stream.advanced;

import java.util.*;

public class FirstRepeatedInteger {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,2,3,6,7,3);
        usingStream(numbers);
        withoutStream(numbers);
    }

    private static void withoutStream(List<Integer> numbers) {
        Integer firstRepeated = null;
        Set<Integer> seen = new HashSet<>();
        for (Integer num : numbers) {
            if (!seen.add(num)) {
                firstRepeated = num;
                break;
            }
        }

        System.out.println(firstRepeated);
    }

    private static void usingStream(List<Integer> numbers) {
        Set<Integer> seen = new HashSet<>();
        Optional<Integer> firstRepeated =
                numbers.stream()
                        .filter(n -> !seen.add(n))
                        .findFirst();

        System.out.println(firstRepeated.orElse(null));
    }
}
