package com.bamzy;

public class Main {

    public static void main(String[] args) {
        LListNode a = new LListNode(2);
        LListNode b = new LListNode(4);
        LListNode c = new LListNode(3);
        a.next = b; b.next =c; c.next = null;
        LListNode d = new LListNode(5);
        LListNode e = new LListNode(6);
        LListNode f = new LListNode(4);
        d.next = e; e.next = f; f.next = null;

        LListNode g = new LListNode(1);
        LListNode h = new LListNode(8);
        LListNode i = new LListNode(0);
        g.next = h; h.next = null; i.next = null;

       AddTwoLinkedLists addTwoLinkedLists = new AddTwoLinkedLists();
       addTwoLinkedLists.addTwoNumbers(a,d);
       addTwoLinkedLists.addTwoNumbers(g,i);
    }
}
