package com.practice.dsa.stream.Basics;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Basics {
    public static void main(String[] args) {
        int []a = {5,8,9,6,3,2,5,8,9};
        findAverage(a);        //TASK 1: find avg from array;
        toUpperCaseMethod_FromArray();  // convert string values to uppercase from array;
        toUpperCaseMethod_FromList();  // convert string values to uppercase from list;
        toUpperCase_First_letterOnly(); //convert to uppercase; firstletter only
        sum_All_EvenNumbers(a);
     }

    private static void sum_All_EvenNumbers(int[] a) {
        int output = Arrays.stream(a).filter(x->x%2==0).sum();
        System.out.println("sum of all even numbers:: "+output);
    }

    private static void toUpperCase_First_letterOnly() {
        String[] strings = {"hello", "world", "java", "streams"};
        String[] firstLetterUpperCaseStrings = Arrays.stream(strings)
                .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
                .toArray(String[]::new);
        System.out.println("First Letter Uppercase Array: " + Arrays.toString(firstLetterUpperCaseStrings));

    }

    private static void toUpperCaseMethod_FromList() {
        List<String> strings = Arrays.asList("Hello", "World", "Java", "Streams");
        List<String> upperCaseStrings = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase List: " + upperCaseStrings);
    }

    private static void toUpperCaseMethod_FromArray() {
        String[] input ={"chandar","thiru","prem","sathish"};
        String[] output = Arrays.stream(input).map(String::toUpperCase).toArray(String[]::new);
        System.out.println("converted to uppercase from array:: "+Arrays.toString(output));
          }

    private static void findAverage(int[] a) {
        double  result = Arrays.stream(a).average().orElse(0);
        System.out.println("average is: "+result);
    }
}
