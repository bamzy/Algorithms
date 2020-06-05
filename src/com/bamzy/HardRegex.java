package com.bamzy;

public class HardRegex {

    public static String StringChallenge(String str) {

        String[] temp =  str.split(" ");
        if (temp.length != 2)
            return "false";
        String pattern = temp[0];
        String value = temp[1];
        int valueIndex = 0;
        int patternIndex = 0;
        while ( patternIndex< pattern.length()){
            if (pattern.charAt(patternIndex) == '+'){
                if (!Character.isLetter(value.charAt(valueIndex)))
                    return "false";
                else {
                    patternIndex++;
                    valueIndex++;
                }
            } else if (pattern.charAt(patternIndex) == '$'){
                if (!Character.isDigit(value.charAt(valueIndex)) || value.charAt(valueIndex) == '0')
                    return "false";
                else {
                    patternIndex++;
                    valueIndex++;
                }
            } else if (pattern.charAt(patternIndex) == '*'){
                int expectedSize = 3;
                if (patternIndex+1<pattern.length() && pattern.charAt(patternIndex+1) == '{') {
                    int endBraceIndex = pattern.indexOf('}', patternIndex + 1);
                    if (endBraceIndex == -1)
                        return "false";
                    expectedSize=  Integer.parseInt(pattern.substring(patternIndex+2,endBraceIndex));
                    patternIndex = endBraceIndex;
                }
                int[] res = checkAstrix(patternIndex,value, valueIndex,1,expectedSize);
                if (res[0] == -1 && res[1] == -1)
                    return "false";
                else {
                    patternIndex = res[0];
                    valueIndex = res[1];
                }
            }
        }
        if (valueIndex < value.length())
            return "false";
        return "true";
    }
    // A recursive function to validate occurance
    public static int[] checkAstrix( int patInd, String value, int valInd, int currentCount,int finalCount){
        if (currentCount < finalCount && valInd == value.length())
            return new int[]{-1,-1};
        if (currentCount == finalCount)
            return new int[]{patInd+1,valInd+1};
        if (value.length() - valInd > 1 && value.charAt(valInd) == value.charAt(valInd+1)  )
            return checkAstrix( patInd, value, valInd+1,currentCount+1, finalCount);

        //If no condition is met;
        return new int[]{-1,-1};
    }
}
