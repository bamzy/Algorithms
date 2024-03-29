package info.bamzy;
/*Note: Try to solve this task in O(n) time using O(1) additional space,
where n is the number of elements in l, since this is what you'll be asked
to do during an interview.

Given a singly linked list of integers, determine whether or not it's a palindrome.

Note: in examples below and tests preview linked lists are presented as arrays
just for simplicity of visualization: in real data you will be given a head node l
of the linked list

Example

For l = [0, 1, 0], the output should be
isListPalindrome(l) = true;

For l = [1, 2, 2, 3], the output should be
isListPalindrome(l) = false.

Input/Output

[execution time limit] 3 seconds (java)

[input] linkedlist.integer l

A singly linked list of integers.

Guaranteed constraints:
0 ≤ list size ≤ 5 · 10^5,
-10^9 ≤ element value ≤ 10^9.

[output] boolean

Return true if l is a palindrome, otherwise return false.*/
public class PalindromeLinkedLists {

    boolean isListPalindrome(ListNode<Integer> l) {
        ListNode temp =l;
        int size = 1;
        if (l==null || l.next == null)
            return true;
        while (temp.next != null){
            temp = temp.next;
            size++;
        }
        int counter =0;
        ListNode current = l, prev = null;
        while (current != null ) {
            if (counter >= size/2){
                temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            } else
                current = current.next;
            counter++;
        }
        ListNode lastNode = prev;
        ListNode firstNode = l;
        while (firstNode != null && lastNode != null){
            if (!firstNode.value.equals( lastNode.value))
                return false;
            firstNode = firstNode.next;
            lastNode = lastNode.next;
        }
        return true;
    }

}
