package com.bamzy.javabasics;

public class InterfaceTester implements TestInterface{
    @Override
    public void test() {
        System.out.println(TestInterface.calc());
    }
    public static void main(String args[]){
        InterfaceTester it = new InterfaceTester();
        it.test();
    }
}
