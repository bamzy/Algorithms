package info.bamzy;
/*Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list, since this is what you'll be asked to do during an interview.

Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.

Example

For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
removeKFromList(l, k) = [1, 2, 4, 5];
For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
removeKFromList(l, k) = [1, 2, 3, 4, 5, 6, 7].*/
public class RemoveFromLinkedList {
    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode<Integer> old = null, temp=l,result;
        result = temp;
        while (temp !=null){
            if (temp.value.equals(k)){
                if (old != null) {
                    old.next = temp.next;
                }
                else {
                    result = result.next;
                    old = null;
                }
            } else
                old = temp;
            temp=temp.next;
        }
        return result;
    }

}
