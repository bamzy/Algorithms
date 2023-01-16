package com.bamzy.google;

public class ReverseLinkedList {
    private static class Item {
        public Item next;
//        public Item prev;
        public int value;
        public Item(int val){
            this.value = val;
        }

    }
    public Item reverse(Item root){
        if(root == null ) return null;
        Item current = root,tmp=null,next=null,first=root;
        tmp = root.next;
        while(tmp!=null){
            next = tmp;
            tmp = next.next;
            next.next = current;
            current = next;

        }
        first.next = null;
        return next;
    }
    public static void runTest(){
        Item a = new Item(1);
        Item b = new Item(2);
        Item c = new Item(3);
        Item d = new Item(4);
        a.next = b;
        b.next = c;
        c.next = d;
        ReverseLinkedList rll = new ReverseLinkedList();
        Item neww = rll.reverse(a);
    }
}
