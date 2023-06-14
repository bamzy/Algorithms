package com.bamzy.javabasics;

public class Rectangle extends Shape{
    public Rectangle() {
        super.name = "rectangle";
    }

    @Override
    public int getSides() {
        return 4;
    }


}
