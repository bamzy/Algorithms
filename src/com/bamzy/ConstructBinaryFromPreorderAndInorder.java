package com.bamzy;

public class ConstructBinaryFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int len = preorder.length;
        TreeNode root = buildTreeW(inorder, preorder, 0, len - 1);
        return  root;
    }
    static int preIndex = 0;
    TreeNode buildTreeW(int[] inOrder, int[] preOrder, int inStart, int inEnd)
    {
        if (inStart > inEnd)
            return null;

        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        TreeNode tNode = null;
        if (preIndex < preOrder.length)
            tNode = new TreeNode(preOrder[preIndex++]);

        /* If this node has no children then return */
        if (inStart == inEnd)
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(inOrder, inStart, inEnd, tNode.val);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        tNode.left = buildTreeW(inOrder, preOrder, inStart, inIndex - 1);
        tNode.right = buildTreeW(inOrder, preOrder, inIndex + 1, inEnd);

        return tNode;
    }
    int search(int[] arr, int start, int end, int value)
    {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }
}
