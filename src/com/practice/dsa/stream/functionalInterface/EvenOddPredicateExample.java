package com.practice.dsa.stream.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EvenOddPredicateExample  {
    public static void main(String[] args) {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        int[] testNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int nums:testNumbers){
            System.out.println("Is " + nums + " even? " + isEven.test(nums));
        }
        List<String> names = Arrays.asList("Naveen", "Thiru", "Prem", "Sathish", "Rajesh");
        Predicate<String>  str = input->input.startsWith("R");
        List<String>output = names.stream().filter(str).collect(Collectors.toList());
        System.out.println(output);

    }
}
