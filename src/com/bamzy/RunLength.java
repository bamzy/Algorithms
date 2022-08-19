package com.bamzy;

public class RunLength {
    public String encodeRunLength(String input){
        StringBuilder sb = new StringBuilder();
        char[] inputChars = input.toCharArray();
        char prevChar = 0;
        int counter = 1;
        for (char currChar:inputChars) {
            if(currChar==prevChar) counter++;
            else {
                if(prevChar != 0){
                    sb.append(counter).append(prevChar);
                    counter=1;

                }
            }
            prevChar = currChar;

        }
        sb.append(counter).append(prevChar);
        return sb.toString();
    }

    public String decodeRunLength(String input){
        StringBuilder sb = new StringBuilder();
        char[] inputChars = input.toCharArray();
        int beginIndex = 0;
        int endIndex = 0;
        for (char currChar: inputChars ){
            if(Character.isDigit(currChar)) endIndex++;
            else {
                int counter = Integer.parseInt(input.substring(beginIndex,endIndex));
                for (int i=0;i<counter;i++){
                    sb.append(input.charAt(endIndex));
                }
                endIndex++;
                beginIndex=endIndex;
            }
        }
        return sb.toString();
    }
}
