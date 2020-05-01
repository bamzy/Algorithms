package com.bamzy;


public class Main {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(99911);
        TreeNode b = new TreeNode(22);
        TreeNode c = new TreeNode(33);
        TreeNode d = new TreeNode(44);
        TreeNode e = new TreeNode(55);
        TreeNode f = new TreeNode(55566);
        a.left = b; a.right = c; b.left = d; c.right = e; d.left = f;
        SerializeDeserializeBST sds = new SerializeDeserializeBST();
        TreeNode res = sds.deserialize(sds.serialize(a));


    }
}
