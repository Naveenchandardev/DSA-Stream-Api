package com.practice.dsa.stream.Basics;

import java.util.Arrays;
import java.util.Comparator;

public class SecondHighestInteger {
    public static void main(String[] args) {
        int[]a={1,2,3,4,2,5,6,3};
       Integer result =  Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(result);
    }
}
