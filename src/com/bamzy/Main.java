package com.bamzy;

public class Main {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(1);
        a.left =b; a.right = c; b.left=d; b.right = e; d.left = f;
        KthSmallestElementBST kthSmallestElementBST = new KthSmallestElementBST();
        System.out.println(kthSmallestElementBST.kthSmallest(a,1));
    }
}
