package com.bamzy;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        double sum = 0;
        for (int i = s.length()-1 ; i >= 0; i--){
            sum +=Math.pow(26,i)*(((int)s.charAt(s.length()-1-i))-64);
        }
        return (int)sum;

    }
}
