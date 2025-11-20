/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {

      if(head == null || head.next == null){
        return true;
      }
      ListNode fast = head;
      ListNode slow = head;
      while(fast != null && fast.next != null){
        slow =slow.next;
        fast = fast.next.next;


      }
      //reverse
      ListNode current = head;
      ListNode prev = null;
      while(current != null){
        ListNode temp = current.next;
        current.next= prev;
        prev = current;
        current = temp;

      }
      ListNode first =head;
      ListNode second = prev;
      while(second != null){
        if(first.val != second.val){
          first = first.next;
          second = second.next;
        }

      }
      return true;

        
    }
}