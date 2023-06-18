package info.bamzy;
/*Given a linked list, reverse the nodes of a linked
list k at a time and return its modified list.

k is a positive integer and is less than or equal to
the length of the linked list. If the number of nodes
is not a multiple of k then left-out nodes in the
end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.*/
public class RevereseKgroupLinkedList {
    class SubsetReverseResult {
        private LListNode newStart, nextStart,newEnd;

        public SubsetReverseResult(LListNode newStart, LListNode nextStart, LListNode newEnd) {
            this.newStart = newStart;
            this.newEnd = newEnd;
            this.nextStart = nextStart;
        }

        public LListNode getNewStart() {
            return newStart;
        }
        public LListNode getNewEnd() {
            return newEnd;
        }

        public LListNode getNextStart() {
            return nextStart;
        }
    }
    public LListNode reverseKGroup(LListNode head, int k) {
        LListNode prevNewStart=null, prevNewEnd=null, prevNextStart=head;
        SubsetReverseResult partialRes = null;
        while(prevNextStart != null){
            partialRes = reverseSubset(prevNextStart,k);
            if (partialRes != null) {
                if (prevNewEnd != null)
                    prevNewEnd.next = partialRes.newStart;
                if (prevNewStart == null)
                    prevNewStart = partialRes.getNewStart();
                prevNewEnd = partialRes.getNewEnd();
                prevNextStart = partialRes.getNextStart();
            } else return null;
        }
        return prevNewStart;
    }
    SubsetReverseResult reverseSubset(LListNode st, int k){
        if (st == null || k == 0)
            return new SubsetReverseResult(null,null,null);
        LListNode temp = st,next=null, prev = null;
        int counter  = 1;
        while (counter<=k){
            if (temp == null) {
                return reverseSubset(prev,counter-1);
            }
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            counter++;
        }
        return new SubsetReverseResult(prev,next,st);
    }
}
