package info.bamzy;

import java.util.LinkedList;

public class BamzyHash {
    private LinkedList<HashItem>[] data;
    private int length;
    private int getHash(String input){
        return input.hashCode();
    }
    public BamzyHash(int length){
        if (length <0) return;
        this.length = length;
        this.data = new LinkedList[length];
    }
    private int getIndex(int hash){
        return hash % this.length;
    }
    public int add(String key,Object value){
        int hash = getHash(key);
        int index = getIndex(hash);
        LinkedList<HashItem> itemLL = this.data[index];
        itemLL.add(new HashItem(key,value));
        return itemLL.size()-1;
    }
    public HashItem get(String key){
        int hash = getHash(key);
        int index = getIndex(hash);
        LinkedList<HashItem> itemLL =  this.data[index];
        for (int i=0;i<itemLL.size();i++){
            if(itemLL.get(i).key == key) return itemLL.get(i);
        }
        return null;

    }
    public class HashItem {

        public String key;
        public Object value;
        public HashItem(String key, Object value){
            this.key = key;
            this.value = value;
        }
    }
}
