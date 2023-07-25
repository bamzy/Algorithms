package info.bamzy;

import java.util.*;

class RandomizedSet {
    private HashMap<Integer,Integer> valueIndex;
    private ArrayList<Integer> values;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueIndex = new HashMap<>();
        values = new ArrayList<>();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueIndex.containsKey(val))
            return false;
        else {
            valueIndex.put(val, values.size());
            values.add(val);
            return true;
        }

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valueIndex.containsKey(val))
            return false;
        else {
            int index = valueIndex.get(val);
            int temp = values.get(values.size()-1);
            values.set(index,temp);
            values.remove(values.size()-1);
            valueIndex.put(temp, index);
            valueIndex.remove(val);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return values.get((int)(Math.random()*values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */