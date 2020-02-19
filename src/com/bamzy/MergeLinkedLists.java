package com.bamzy;
/*Note: Your solution should have O(l1.length + l2.length) time
complexity, since this is what you will be asked to accomplish in an interview.

Given two singly linked lists sorted in non-decreasing order,
your task is to merge them. In other words, return a singly linked
list, also sorted in non-decreasing order, that contains the elements
from both original lists.

Example

For l1 = [1, 2, 3] and l2 = [4, 5, 6], the output should be
mergeTwoLinkedLists(l1, l2) = [1, 2, 3, 4, 5, 6];
For l1 = [1, 1, 2, 4] and l2 = [0, 3, 5], the output should be
mergeTwoLinkedLists(l1, l2) = [0, 1, 1, 2, 3, 4, 5].
Input/Output

[execution time limit] 3 seconds (java)

[input] linkedlist.integer l1

A singly linked list of integers.

Guaranteed constraints:
0 ≤ list size ≤ 104,
-109 ≤ element value ≤ 109.

[input] linkedlist.integer l2

A singly linked list of integers.

Guaranteed constraints:
0 ≤ list size ≤ 104,
-109 ≤ element value ≤ 109.*/
public class MergeLinkedLists {
    ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> first = l1, second = l2, firstPrev=null,temp,result;
        if (l1.value<l2.value)
            result = l1;
        else
            result = l2;
        while (first != null && second != null){
            if (first.value >= second.value){
                temp = second.next;
                if (firstPrev !=null){
                    firstPrev.next = second;
                    second.next = first;
                } else {
                    second.next = first;
                }
                firstPrev = second;
                if (temp!=null)
                    second = temp;
                else second = null;
            } else {
                firstPrev= first;
//                result = l1;
                if (first!=null && first.next!=null)
                    first = first.next;
                if (first != null && first.next == null) {
                    first.next = second;
                    break;
                }

            }

        }
        return result;
    }

}
