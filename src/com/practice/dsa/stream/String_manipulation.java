package com.practice.dsa.stream;

import java.util.Arrays;

public class String_manipulation {
    public static void main(String[] args) {
        String[] stringArray = {"a", null, "b", null, "c"};
        String[] replacedArray = Arrays.stream(stringArray)
                .map(str -> str == null ? "chandar" : str)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(replacedArray));
    }
}
