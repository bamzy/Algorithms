package info.bamzy;

import java.util.HashMap;
import java.util.LinkedList;

public class PrintLevelTree
{

    public void print(NNode root, int level, HashMap<Integer,LinkedList<NNode>> map){
        if (root == null ) return;
        if(!map.containsKey(level)){
            LinkedList<NNode> item = new LinkedList<>();
            item.add(root);
            map.put(level, item);
        } else {
            LinkedList<NNode> item = map.get(level);
            item.add(root);
        }

        print(root.left,level+1,map);
        print(root.right,level+1,map);
    }
    public void solve(NNode root){

        HashMap<Integer,LinkedList<NNode>> map = new HashMap<>();
        print(root,0,map);
        for (int i = 0; i< map.size(); i++) {
            if(map.containsKey(i)){
                LinkedList<NNode> ll =  map.get(i);
                for (NNode tmp : ll) {
                    System.out.println("val for " + i + ":" + tmp.value);
                }
            }
        }

    }
}
