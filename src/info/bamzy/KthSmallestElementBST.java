package info.bamzy;

public class KthSmallestElementBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
        public int kthSmallest(TreeNode root, int k) {
            inOrder(root,k);
            return result;
        }
        int counter = 0;
        int result;
        private void inOrder(TreeNode root, int k) {
            if (root == null || counter>k)
                return;
            inOrder(root.left,k);
            counter++;
            if (counter == k)
                result = root.val;
            inOrder(root.right,k);
        }
}
