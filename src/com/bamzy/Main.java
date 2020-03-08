package com.bamzy;

public class Main {

    public static void main(String[] args) {
        LListNode a = new LListNode(4);
        LListNode b = new LListNode(1);
        LListNode c = new LListNode(8);
        LListNode d = new LListNode(4);
        LListNode e = new LListNode(5);
        LListNode f = new LListNode(5);
        LListNode g = new LListNode(0);
        LListNode h = new LListNode(1);

        a.next = b; b.next = c; c.next = d; d.next = e;
        f.next =g;g.next = h; h.next = c;
        IntersectionOfLinkedLists intersectionOfLinkedLists = new IntersectionOfLinkedLists();
        intersectionOfLinkedLists.getIntersectionNode(a,f);
    }
}
