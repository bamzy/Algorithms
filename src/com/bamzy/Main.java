package com.bamzy;

public class Main {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b; a.right = c; c.left = d; c.right = e;
        SerializeDeserializeBST codec = new SerializeDeserializeBST();
        System.out.println(codec.serialize(a));
    }
}
