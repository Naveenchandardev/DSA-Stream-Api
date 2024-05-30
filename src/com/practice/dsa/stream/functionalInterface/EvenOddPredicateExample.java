package com.practice.dsa.stream.functionalInterface;

import java.util.function.Predicate;

public class EvenOddPredicateExample  {
    public static void main(String[] args) {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        int[] testNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int nums:testNumbers){
            System.out.println("Is " + nums + " even? " + isEven.test(nums));
        }

    }
}
