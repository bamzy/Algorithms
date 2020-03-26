package com.bamzy;

import java.util.List;

public class Main {

    public static void main(String[] args) {
       TopKfrequentElement topKfrequentElement = new TopKfrequentElement();
        var integers = topKfrequentElement.topKFrequent(new int[]{1, 0, 2, 4, 2, 1, 4, 3, 0}, 3);
        System.out.printf("integers");
    }
}
