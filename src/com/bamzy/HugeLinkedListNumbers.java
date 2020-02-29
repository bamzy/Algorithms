package com.bamzy;

public class HugeLinkedListNumbers {
    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> temp = a,prev1 = null, prev2=null, next1,next2,prev;
        while (temp != null) {
            next1 = temp.next;
            temp.next =prev1;
            prev1 = temp;
            temp = next1;
        }
        temp = b;
        while (temp != null) {
            next2 = temp.next;
            temp.next =prev2;
            prev2 = temp;
            temp = next2;
        }
        int carryOver = 0;
        ListNode<Integer> head = new ListNode<>(0);
        temp = head;
        while (prev1 != null || prev2!=null || carryOver !=0){
            Integer sum = 0;
            if (prev1!=null && prev2!= null) {
                sum = prev1.value + prev2.value + carryOver;
            } else if (prev1 == null && prev2 != null) {
                sum = prev2.value + carryOver;
            } else if (prev1 != null && prev2 == null) {
                sum = prev1.value + carryOver;
            } else if (prev1 == null && prev2 == null && carryOver != 0) {
                sum = carryOver;
            }
            if (sum > 9999)
                carryOver = 1;
            else carryOver = 0;

            prev = new ListNode<>(sum%10000);
            temp.next =  prev;
            temp = temp.next;
            if (prev1 != null)
                prev1 = prev1.next;
            if (prev2 != null)
                prev2 = prev2.next;
        }
        ListNode temp2 = head.next;
        prev2=null;
        while (temp2 != null) {
            next2 = temp2.next;
            temp2.next =prev2;
            prev2 = temp2;
            temp2 = next2;
        }
        return prev2;
    }

}
