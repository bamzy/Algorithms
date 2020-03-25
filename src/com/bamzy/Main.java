package com.bamzy;

public class Main {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(1);
        a.left = b; b.left = c; c.left = d; d.left = e;
        SerializeDeserializeBST codec = new SerializeDeserializeBST();
        TreeNode res = codec.deserialize(codec.serialize(f));
        System.out.println(res);


    }
}
