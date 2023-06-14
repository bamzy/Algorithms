package com.bamzy.javabasics;

public class Triangle extends Shape{
    public Triangle() {
        super.name = "triangle";
    }

    @Override
    public int getSides() {
        return 3;
    }


}
