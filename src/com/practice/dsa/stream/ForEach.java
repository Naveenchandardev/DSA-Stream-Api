package com.practice.dsa.stream;

import java.util.stream.Stream;

public class ForEach {
    public static void main(String[] args) {
        //print values one by one;
        String input ="Technical";
        Stream<String> stream = Stream.of("TCS", "Zoho", "Infosys", "Accenture","IBM");
        singleValue(input);
        listOfString(stream);
    }

    private static void listOfString(Stream input) {
        System.out.println("Print list of string");
        input.forEach(a-> System.out.print(a +" "));
    }

    private static void singleValue(String input) {
        System.out.println("Print string characters");
        input.chars().mapToObj(ch ->(char)ch).forEach(System.out::print);
        System.out.println();
    }
}
