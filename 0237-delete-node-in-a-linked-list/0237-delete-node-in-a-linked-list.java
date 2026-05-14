/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */



class Solution {
    public void deleteNode(ListNode node) {
        
        // Copy next node value
        node.val = node.next.val;
        
        // Skip next node
        node.next = node.next.next;
    }
}