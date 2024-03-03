package com.practice.dsa.stream;

import java.util.Arrays;

public class FilterMethods {
    //print the name starts with 's' or end with 'h'
    public static void main(String[] args) {
        String [] a = {"naveen","santhosh","naren","rajesh","prem","shanmugam"};
        Arrays.stream(a).filter(x->x.startsWith("s") ||x.endsWith("h")).forEach(System.out::println);
    }
}
