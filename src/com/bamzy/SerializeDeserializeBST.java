package com.bamzy;

import java.util.*;

public class SerializeDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeUtil(root, sb);
        return sb.toString();
    }

    private void serializeUtil(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("#");
            return;
        }
        sb.append((char)(root.val + '0'));
        serializeUtil(root.left,sb);
        serializeUtil(root.right,sb);
    }

    int index=0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeUtil(data.toCharArray());
    }

    private TreeNode deserializeUtil(char[] data){
        if (data[index] == '#'){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(data[index++] - '0');
        root.left = deserializeUtil(data);
        root.right = deserializeUtil(data);
        return root;
    }





}
