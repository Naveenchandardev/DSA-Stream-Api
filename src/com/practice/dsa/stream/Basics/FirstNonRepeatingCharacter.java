package com.practice.dsa.stream.Basics;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str ="firstnonrepeatingcharacter";
        Character c = str.chars()
                .mapToObj(x -> (char)x)
                .filter(ch -> str.indexOf(ch) == str.lastIndexOf(ch))
                .findFirst()
                .orElse(null);
        System.out.println(c);
    }
}
