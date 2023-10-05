package com.workintech.s15d4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.Stack;

public class Main {
    private static final String Stack = null;

    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));
        System.out.println(decimalToBinary(13));
        System.out.println(decimalToBinary(6));
        System.out.println(decimalToBinary(5));
        System.out.println(checkForPalindrome2("abccba"));
        System.out.println(checkForPalindrome2("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome2("I did, did I?"));
        System.out.println(checkForPalindrome2("hello"));
        System.out.println(checkForPalindrome2("Don't node"));

    }

    public static boolean checkForPalindrome(String text) {
        text = text.replaceAll("[.,'?!_-]", "").replace(" ", "").toLowerCase(new Locale("en"));
        char[] chars = text.toCharArray();
        Stack<Character> charStack = new Stack<>();
        for(char c: chars){
            charStack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while(!charStack.isEmpty()){
            reversed.append(charStack.pop());
        }
        return text.equals(reversed.toString());
    }

    public static boolean checkForPalindrome2(String text) {
        text = text.replaceAll("[.,'?!_-]", "").replace(" ", "").toLowerCase(new Locale("en"));
        char[] chars = text.toCharArray();
        Stack<Character> charStack = new Stack<>();
        Queue<Character> charQueue = new LinkedList<>();
        for(char c: chars){
            charStack.push(c);
            charQueue.add(c);
        }
        while(!charStack.isEmpty()){
            if(!charStack.pop().equals(charQueue.remove())){
                return false;
            }
        }
        return true;
    }

    public static int decimalToBinary(int number) {
        Stack<Integer> binary = new Stack<>();
        while(number > 1){
            binary.push(number % 2);
            number = number / 2;
        }
        binary.push(number % 2);
        String num = "";
        while(!binary.isEmpty()){
            num += binary.pop();
        }
        return Integer.parseInt(num); 
    }
}