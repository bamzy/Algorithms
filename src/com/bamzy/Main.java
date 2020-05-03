package com.bamzy;


public class Main {

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(7,4));
        System.out.println(divideTwoIntegers.divide(-2147483648,1));
        System.out.println(divideTwoIntegers.divide(-2147483648,2));
    }
}
