package com.bamzy;

public class Main {

    public static void main(String[] args) {
//        TreeNode a = new TreeNode(1);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(3);
//        TreeNode d = new TreeNode(4);
//        TreeNode e = new TreeNode(5);
//        TreeNode f = new TreeNode(6);
//        TreeNode g = new TreeNode(7);

//        TreeNode a = new TreeNode(3);
//        TreeNode b = new TreeNode(9);
//        TreeNode c = new TreeNode(20);
//        TreeNode d = new TreeNode(15);
//        TreeNode e = new TreeNode(7);
//        a.left =b; a.right = c;  c.left = d; c.right = e;

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.left =b; a.right = c;  b.left = d; b.right = e; c.left = f; c.right =g;
        PopulatingNextRightPointerInNode populatingNextRightPointerInNode = new PopulatingNextRightPointerInNode();
        System.out.println("Zigzag: "+populatingNextRightPointerInNode.connect(a));
    }
}
