package com.bamzy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preorder(root,result);
        return result;
    }
    private void preorder(TreeNode node,List<Integer> result){
        if(node == null) return;
        result.add(node.val);
//        if (node.left == null && node.right == null) result.add(node.val);
        if (node.left != null) preorder(node.left,result);
        if (node.right != null) preorder(node.right,result);
    }

    public static void runTest(){
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        root.right = two;
        two.left = three;
        BinaryTreePreorderTraversal btpt = new BinaryTreePreorderTraversal();
        System.out.println("Test case 1:"+ btpt.preorderTraversal(root));

        System.out.println("Test case 2:"+ btpt.preorderTraversal(null));

        TreeNode root2 = new TreeNode(1);
        System.out.println("Test case 3:"+ btpt.preorderTraversal(root2));


    }
}
