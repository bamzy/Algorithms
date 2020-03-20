package com.bamzy;

import java.util.*;

/*
// Definition for a Node.

*/
public class PopulatingNextRightPointerInNode {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        int levelSize = bfsQueue.size(), count = 0;
        List<Integer> first = new ArrayList<>();
        root.next = null;
        first.add(root.val);
        boolean flip = true;
        while(!bfsQueue.isEmpty()) {
            Node curr = bfsQueue.poll();
            if(curr.left != null) {
                bfsQueue.offer(curr.left);
            }
            if(curr.right != null) {
                bfsQueue.offer(curr.right);
            }
            count++;
            if(count == levelSize){
                count = 0;
                levelSize = bfsQueue.size();
                Node prev = null;
                for(Node current : bfsQueue) {
                    if (prev != null)
                        prev.next = current;
                    prev = current;
                }
            }
        }
        return root;
    }
}
