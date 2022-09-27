package com.bamzy;
/*
6. Determine if a binary tree is a binary search tree
Given a Binary Tree, figure out whether it’s a Binary Search Tree. In a binary search tree,
each node’s key value is smaller than the key value of all nodes
in the right subtree, and is greater than the key values of all nodes in the left subtree. Below is an example of a binary tree that is a valid BST.

 */
public class CheckIfBinaryTreeIsSearchBinaryTree {

    public boolean check(NNode root){
        if(root == null ) return true;
        if(root.left != null &&  root.left.value> root.value)
            return false;
        if(root.right!= null && root.value > root.right.value) {
            return false;
        } else return check(root.left) && check(root.right);
    }
}
