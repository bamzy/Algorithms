package com.bamzy;

public class Main {

    public static void main(String[] args) {
//        TreeNode a = new TreeNode(5);
//        TreeNode b = new TreeNode(3);
//        TreeNode c = new TreeNode(6);
//        TreeNode d = new TreeNode(2);
//        TreeNode e = new TreeNode(4);
//        TreeNode f = new TreeNode(1);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left =b; a.right = c; b.left=d; b.right = e;
        XOrderTraversal xOrderTraversal = new XOrderTraversal();
        System.out.println("Inorder: "+ xOrderTraversal.inorderTraversal(a));
        System.out.println("Preorder: "+ xOrderTraversal.preorderTraversal(a));
        System.out.println("Postorder: "+xOrderTraversal.postorderTraversal(a));
    }
}
