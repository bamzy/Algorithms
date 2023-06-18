package info.bamzy;

import java.util.Stack;

public class StackExampleValidate{
    public static void runTest(){
        StackExampleValidate sev = new StackExampleValidate();
        System.out.println(sev.validate("(())"));
        System.out.println(sev.validate("()())"));

    }

    // (()())

    public boolean validate(String input){
        int blockCounter = 0;
        Stack<Character> stack = new Stack<>();
        System.out.println(input);
        for(int i =0; i< input.length();i++){
            char currentChar = input.charAt(i);
            if(currentChar =='(') stack.push(currentChar);
            else if (currentChar == ')') {
                blockCounter++;
                if(stack.size()>0) stack.pop();
                else return false;
            }
            else return false;
        }
        if(stack.size()!=0)return false;
        return true;
    }
}