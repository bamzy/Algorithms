package com.bamzy;


import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HardRegex hardRegex = new HardRegex();
        System.out.println(hardRegex.StringChallenge( "*{1} ")); // false
        System.out.println(hardRegex.StringChallenge( "+++++* abcdehhhhhh")); // false
        System.out.println(hardRegex.StringChallenge( "++*{5} jtggggg")); //true
        System.out.println(hardRegex.StringChallenge( "$**+*{2} 9mmmrrrkbb")); // true

    }
}
