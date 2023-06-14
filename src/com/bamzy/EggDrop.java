package com.bamzy;

import java.util.HashMap;

public class EggDrop {
    public int solve_recursive(int eggs, int floors){
        dp.clear();
        return rec(eggs,floors);
    }
    HashMap<String,Integer> dp = new HashMap<>();

    private int rec(int eggs, int floors) {

        int min = Integer.MAX_VALUE;
//        System.out.println(eggs + "  "+ floors);
        if(eggs==1) return floors;
        if(floors==1) return 1;
        if(floors ==0) return 0;
        String key = eggs+"|"+floors;
        if(dp.containsKey(key)) return dp.get(key);
        for(int i=1;i<floors;i++){
            min = Math.min(min,Math.max(rec(eggs-1,i-1),rec(eggs,floors-i)));
        }
        dp.put(key,min+1);
        return min+1;
    }
}
