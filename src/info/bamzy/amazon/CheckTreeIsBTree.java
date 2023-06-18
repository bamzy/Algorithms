package info.bamzy.amazon;

import info.bamzy.TreeNode;

public class CheckTreeIsBTree {
    public boolean check(TreeNode root){
        if (root == null ) return true;
        if (root.left != null && root.left.val > root.val) return false;
        if (root.right != null && root.right.val <= root.val) return false;
        return check(root.left) && check(root.right);
    }
}
