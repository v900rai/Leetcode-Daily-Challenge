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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;

        // check if nodes are ≥ k
        for (int i = 0; i < k; i++) {
            if (temp == null)
             return head;
            temp = temp.next;
        }

        // reverse first K nodes
        ListNode prev = null;
        ListNode  curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // recursion for remaining list
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
