package com.bamzy;

public class Main {

    public static void main(String[] args) {
        LListNode a = new LListNode(1);
        LListNode b = new LListNode(2);
        LListNode c = new LListNode(3);
        LListNode d = new LListNode(4);
        LListNode e = new LListNode(5);
        LListNode f = new LListNode(6);
        LListNode g = new LListNode(7);
        LListNode h = new LListNode(8);

        a.next = b; b.next = c; c.next = d; d.next = e; e.next = f; f.next =g;g.next = h;
        OddEvenLinkedLists oddEvenLinkedLists = new OddEvenLinkedLists();
        oddEvenLinkedLists.oddEvenList(a);
    }
}
