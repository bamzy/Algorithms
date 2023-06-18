package info.bamzy;

public class AddTwoLinkedLists {
    public LListNode addTwoNumbers(LListNode l1, LListNode l2) {
        LListNode temp = l1,prev1 = null, prev2=null, next1,next2,prev;
        int carryOver = 0;
        prev1 = l1;
        prev2= l2;
        LListNode head = new LListNode(0);
        temp = head;
        while (prev1 != null || prev2!=null || carryOver !=0){
            Integer sum = 0;
            if (prev1!=null && prev2!= null) {
                sum = prev1.val + prev2.val + carryOver;
            } else if (prev1 == null && prev2 != null) {
                sum = prev2.val + carryOver;
            } else if (prev1 != null && prev2 == null) {
                sum = prev1.val + carryOver;
            } else if (prev1 == null && prev2 == null && carryOver != 0) {
                sum = carryOver;
            }
            if (sum > 9)
                carryOver = 1;
            else carryOver = 0;
            prev = new LListNode(sum%10);
            temp.next =  prev;
            temp = temp.next;
            if (prev1 != null)
                prev1 = prev1.next;
            if (prev2 != null)
                prev2 = prev2.next;
        }
        LListNode temp2 = head.next;
        return temp2;
    }
}
