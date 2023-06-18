package info.bamzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class BogoSort {
    public ArrayList<Integer> sort() {
        Random rand  = new Random();
        ArrayList<Integer> input = new ArrayList<>();
        for(int i =0;i<5;i++){

            input.add(rand.nextInt(1000));
        }
        return sort(input);

    }
    public ArrayList<Integer> sort(ArrayList<Integer> input){
        while(!isSorted(input)){
            Collections.shuffle(input);
        }
        input.forEach(integer -> System.out.println(integer));
        return input;
    }
    private boolean isSorted(ArrayList<Integer> input){
        int prev = input.get(0);
        for(int i=1;i<input.size();i++) if(input.get(i)<prev) return false;
        return true;
    }
}
