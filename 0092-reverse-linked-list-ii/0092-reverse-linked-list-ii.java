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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to simplify the edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head; //next bna diya hu 

        // Find the node before the left position
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Reverse the sublist
        ListNode curr = prev.next;
        ListNode next = null;
        ListNode prevNode = null;
        for (int i = 0; i <= right - left; i++) {
            next = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = next;
        }

        // Connect the reversed sublist with the rest of the list
        prev.next.next = curr;
        prev.next = prevNode;

        return dummy.next;
    }
}
