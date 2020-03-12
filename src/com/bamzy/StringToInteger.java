package com.bamzy;

public class StringToInteger {
    public int myAtoi(String str) {
        int index = 0;
        long result=0;
        int positiveFlag = 1;
        boolean numberStarted = false;
        while (index < str.length()) {

            if (str.charAt(index) == ' ' && !numberStarted){
                index++;
            } else if (str.charAt(index) == '-' && !numberStarted){
                positiveFlag = positiveFlag * (-1);
                numberStarted = true;
                index++;
            } else if(str.charAt(index) == '+' && !numberStarted) {
                positiveFlag = positiveFlag * (+1);
                numberStarted = true;
                index++;
            } else {
                if ( (int)(str.charAt(index)) >= 48 && (int)(str.charAt(index)) <= 57){
                        numberStarted =true;
                        result = result*10 + (str.charAt(index++)-48);
                        if (result > Integer.MAX_VALUE){
                            if (positiveFlag > 0)
                                return Integer.MAX_VALUE;
                            else
                                return Integer.MIN_VALUE;
                        }
                } else if (!numberStarted){
                    return 0;
                } else if (numberStarted){
                    break;
                }
            }
        }
        return positiveFlag*(int)result;
    }
}
