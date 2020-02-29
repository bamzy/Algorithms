package com.bamzy;

import java.util.ArrayList;
import java.util.Stack;

public class FindTreePathBySum {

    boolean findTreePathEqualToSum(MyTree<Integer> root,int totalSum){
        Stack<MyTree<Integer>> queue = new Stack<>();
        root.parentSum = 0;
        queue.push(root);
        MyTree<Integer> current;
        while (queue.size() > 0){
            current = queue.pop();
            if (current.right !=null) {
                current.right.parentSum = current.value + current.parentSum;
                queue.push(current.right);
            }
            if (current.left != null) {
                current.left.parentSum = current.value + current.parentSum;
                queue.push(current.left);
            }
            if (current.left == null && current.right == null){
                if (current.parentSum + current.value == totalSum)
                       return true;
            }
        }
        return false;
    }


    boolean hasPathSum(TreeNode root,int sum){
        if (root == null )
            return false;
        if (root.left == null && root.right == null){
            if (root.val == sum)
                return true;
            return false;
        }
        return (hasPathSum(root.left,sum- root.val ) || hasPathSum(root.right,sum-root.val));
    }
}
