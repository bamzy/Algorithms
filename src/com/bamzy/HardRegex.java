package com.bamzy;

public class HardRegex {

    public  String StringChallenge(String str) {
        // code goes here
        int index = 0;
        String pattern = str.split(" ")[0];
        String value = str.split(" ")[1];
        for (int i =0; i< pattern.length();i++){
            if (pattern.charAt(i) == '+'){
                if (!Character.isLetter(value.charAt(index)))
                    return "false";
            } else if (pattern.charAt(i) == '$'){
                if (!Character.isDigit(value.charAt(index)) || value.charAt(index) == '0')
                    return "false";
            } else if (pattern.charAt(i) == '*'){
                int ind1 = pattern.indexOf('{');
                int ind2 = pattern.indexOf('}');
                int count = -1;
                if (ind1 != 0 && ind2 != 0){
                    count = Integer.parseInt(value.substring(ind1,ind2+1));
                }
                if (!checkAstrix(pattern.substring(i),value.substring(index),count))
                    return "false";
            }
            index++;

        }
        return "true";
    }
    public  boolean checkAstrix(String pattern,String value, int count){
        return true;
    }
}
