/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // public void deleteNode(ListNode node) {
    //   node.val=node.next.val;
    //   node.next=node.next.next;
        
    // }
        public void deleteNode(ListNode node) {
       if(node.next==null){
        return ;
       }
        ListNode current = node;
        ListNode prev = null;
        while(current.next != null){
            current.val = current.next.val;
            prev = current;
            current = current.next;
        }
        prev.next = null;
    }

        
}