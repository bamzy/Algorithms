package com.bamzy;

import java.util.*;

public class Main {
    // Refers to the max size of the map following which
    // the removal takes place of the eldest entry
    private static final int MAX = 6;
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(2));

    }
}
