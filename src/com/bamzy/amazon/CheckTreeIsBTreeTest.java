package com.bamzy.amazon;

import com.bamzy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the level order
 * traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 */
public class CheckTreeIsBTreeTest {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> map = new ArrayList<>();
        dfs(root,0,map);
        return map;

    }

    private void dfs(TreeNode root, int i, List<List<Integer>> map) {
        if(root==null) return;
        if (map.size()<=i) map.add(new ArrayList<>());
        map.get(i).add(root.val);
        dfs(root.left,i+1,map);
        dfs(root.right,i+1,map);
    }
}
