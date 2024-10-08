/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}

 *    ListNode(int val)
  { this.val = val; }
 *     ListNode(int val, ListNode next) 
  { this.val = val; this.next = next; }
 * }
 */
// Definition for singly-linked list.

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // dummy node to store the result
        ListNode current = dummyHead;
        int carry = 0; // to store the carry
        
        // Iterate over both lists while either of them has a node or there is a carry left
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0; // get the value from l1 or 0 if null
            int y = (l2 != null) ? l2.val : 0; // get the value from l2 or 0 if null
            int sum = x + y + carry; // calculate sum including carry
            
            carry = sum / 10; // update carry for next position
            current.next = new ListNode(sum % 10); // create new node with the digit
            
            current = current.next; // move current pointer
            
            if (l1 != null) l1 = l1.next; // move l1 pointer if available
            if (l2 != null) l2 = l2.next; // move l2 pointer if available
        }
        
        return dummyHead.next; // return the result list starting from next of dummy node
    }
}
