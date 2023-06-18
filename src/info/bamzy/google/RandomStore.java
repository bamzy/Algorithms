package info.bamzy.google;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomStore {
    int arrayRsize = 0;
    HashMap<Integer,Integer> set;
    ArrayList<Integer> backup = new ArrayList<>();
    public RandomStore(){
        set = new HashMap<>();
    }
    public void insert(int i){
        if(set.containsKey(i)) return;
        backup.add(arrayRsize,i);
        set.put(i,arrayRsize);
        arrayRsize++;
    }
    public void remove(int i){
        if( !set.containsKey(i)) return;
        int tobeRemovedIndex = set.get(i);
        //backup.remove(tobeRemovedIndex);
        int tobeRemovedValue = backup.get(tobeRemovedIndex);
        int lastValue = backup.get(backup.size()-1);
        backup.set(tobeRemovedIndex,lastValue);
        backup.remove(backup.size()-1);
        set.put(lastValue,tobeRemovedIndex);
        arrayRsize--;
        set.remove(i);

    }
    /*public int random(){
        Object[] objects = set.toArray();
        Integer[] intArray = Arrays.copyOf(objects, objects.length, Integer[].class);

        int random = (int) Math.floor(Math.random() * intArray.length);
        return intArray[random];
    }
    public int random2(){
        int random = (int) Math.floor(Math.random() * set.size());
        int counter = 0;
        for( Integer i: set){
            if(counter==random) return i;
            counter++;
        }
        return -1;
    }*/
    public int random3(){
        int random = (int)(Math.random()*arrayRsize);
        return backup.get(random);
    }

    public static void runTest(){
        RandomStore rs = new RandomStore();
        rs.insert(1);
        rs.insert(2);
        rs.insert(3);
        rs.insert(4);
        rs.insert(5);
        rs.insert(6);
        rs.remove(7);
        rs.remove(1);
        rs.remove(4);


        System.out.println("--->"+ rs.random3());
        System.out.println("--->"+ rs.random3());
        System.out.println("--->"+ rs.random3());
        System.out.println("--->"+ rs.random3());
    }
}
