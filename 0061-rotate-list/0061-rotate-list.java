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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head; // Edge case: Empty list or no rotation needed
        }

        // Step 1: Calculate the length of the list
        ListNode curr = head;
        int n = 1; // Start with 1 as we are already at head
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }

        // Step 2: Reduce k using modulo operation
        k = k % n;
        if (k == 0) {
            return head; // No rotation needed
        }

        // Step 3: Connect the last node to the head to form a circular list
        curr.next = head;

        // Step 4: Find the new tail (n - k - 1) and new head (n - k)
        int stepsToNewHead = n - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break the circular list
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
