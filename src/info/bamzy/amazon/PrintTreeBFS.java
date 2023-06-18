package info.bamzy.amazon;

import info.bamzy.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrintTreeBFS {
    public HashMap<Integer, List<Integer>> getBFS(TreeNode root){
        HashMap<Integer, List<Integer>> result = new HashMap<>();
        bfs(root,0,result);
        return result;
    }

    private void bfs(TreeNode root, int i, HashMap<Integer, List<Integer>> result) {
        if( root == null) return;
        List<Integer> list = null;
        if(!result.containsKey(i)) {
            list = new ArrayList<>();
            result.put(i,list);
        }
        else list = result.get(i);
        list.add(root.val);
        bfs(root.left,i+1,result);
        bfs(root.right,i+1,result);
    }

    public void print(TreeNode root){
        HashMap<Integer, List<Integer>> listOfList = getBFS(root);
        for (Integer listIndex : listOfList.keySet()){
            for (Integer val : listOfList.get(listIndex)){
                System.out.print(val+", ");
            }
            System.out.println("\n----------------------");
        }
    }

}
