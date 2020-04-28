package com.bamzy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static class Item {
        int workerId;
        int manhattanDistance;

        public Item(int workerId, int manhattanDistance) {
            this.workerId = workerId;
            this.manhattanDistance = manhattanDistance;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Item> queue = new PriorityQueue<>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.manhattanDistance == o2.manhattanDistance)
                    return o1.workerId - o2.workerId;
                else
                    return o1.manhattanDistance - o2.manhattanDistance;
            }
        });
        queue.add(new Item(1,1));
        queue.add(new Item(3,1));
        queue.add(new Item(2,1));
        queue.add(new Item(4,1));
        System.out.println(queue.poll().workerId);
        System.out.println(queue.poll().workerId);
        System.out.println(queue.poll().workerId);
        System.out.println(queue.poll().workerId);
    }
}
