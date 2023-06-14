package com.bamzy.javabasics;

public abstract class Shape {
    public String name;
    public int test(){
        return 1;
    }
    public abstract int getSides();

    public String introduce() {
        return "I am a "+ this.name + " with "+ getSides()+ " sides";
    }

}
