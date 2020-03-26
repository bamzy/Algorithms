package com.bamzy;

import java.util.*;

public class TopKfrequentElement {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countsToNumbers = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(
                (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (int num : nums) {
            if (countsToNumbers.containsKey(num))
                countsToNumbers.put(num, countsToNumbers.get(num) + 1);
            else
                countsToNumbers.put(num, 1);
        }
        for (Map.Entry<Integer,Integer> entry: countsToNumbers.entrySet())
            queue.offer(entry);
        while(k--!=0) result.add(queue.poll().getKey());
        return result;
    }
}
