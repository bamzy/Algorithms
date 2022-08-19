package com.bamzy;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationPhoneNumber {
    private List<String> finalResult = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return finalResult;
        rec(digits,"");
        return finalResult;
    }

    private void rec(String digits, String result) {
        if (digits.length() == 0) {
            finalResult.add(result);
            return;
        }
        int digit = Integer.parseInt(digits.substring(0,1))-2;
        digit = digit *3;
        if (digit >= 0 && digit <=12){
            rec(digits.substring(1),result + Character.toString(digit+97));
            rec(digits.substring(1),result + Character.toString(digit+98));
            rec(digits.substring(1),result + Character.toString(digit+99));
        }
        else if (digit == 15) {
            rec(digits.substring(1), result + Character.toString(digit + 97));
            rec(digits.substring(1), result + Character.toString(digit + 98));
            rec(digits.substring(1), result + Character.toString(digit + 99));
            rec(digits.substring(1), result + Character.toString(digit + 100));
        } else if (digit == 18){
            rec(digits.substring(1), result + Character.toString(digit + 98));
            rec(digits.substring(1), result + Character.toString(digit + 99));
            rec(digits.substring(1), result + Character.toString(digit + 100));
        } else if (digit == 21){
            rec(digits.substring(1), result + Character.toString(digit + 98));
            rec(digits.substring(1), result + Character.toString(digit + 99));
            rec(digits.substring(1), result + Character.toString(digit + 100));
            rec(digits.substring(1), result + Character.toString(digit + 101));
        }
    }
}
