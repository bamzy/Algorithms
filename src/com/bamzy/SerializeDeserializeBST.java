package com.bamzy;

import java.util.*;

public class SerializeDeserializeBST {
    // Encodes a tree to a single string.




    /**
     * Time Complexity = O(N) where N is number of nodes.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        //We use a queue to store next layer of nodes we need to serialize
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        StringBuilder s = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    s.append(cur.val + ",");
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else {
                    s.append("null,");
                }
            }
        }

        return s.toString();
    }


    /**
     * Time Complexity = O(N) where N is number of nodes.
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] s = data.split(",");
        Queue<String> queue = new LinkedList();

        //Since the binary Tree is serizial by BFS, we can store the nodes into a Queue, it will sequence by layer
        queue.addAll(Arrays.asList(s));
        //Init a head
        TreeNode head = new TreeNode(Integer.parseInt(queue.poll()));

        //Offer head to a queue, we will build tree from top to bottom
        Queue<TreeNode> nodes = new LinkedList();
        nodes.offer(head);

        //Look into queue, if there are nodes, we need to continue build the tree
        while (!queue.isEmpty()) {

            //In each layer, we subLeftTree and RightTree for each node, and if node are null, we don't store it into queue
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                //Build left
                String left = queue.poll();
                if (!left.equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(left));
                    nodes.offer(node.left);
                }
                //Build right
                String right = queue.poll();
                if (!right.equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(right));
                    nodes.offer(node.right);
                }
            }
        }
        return head;
    }


}
