package com.practice.dsa.stream;

import java.util.stream.IntStream;

public class Palindrome {
    public static void main(String[] args) {
        String input = "Repaper";
        System.out.println("StreamApi method:: "+usingStreamApi(input.toLowerCase())); //using stream api;
    }
    //THIS TRADITIONAL logic converted into this stream logic;
//        for (int i = str.length() - 1; i >= 0; i--) {
//            reversed.append(str.charAt(i));
//        }
    private static boolean usingStreamApi(String input)  {
        String reversed = IntStream.range(0, input.length())
                .mapToObj(i -> input.charAt(input.length() - i - 1))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return input.equals(reversed);
    } 
}
