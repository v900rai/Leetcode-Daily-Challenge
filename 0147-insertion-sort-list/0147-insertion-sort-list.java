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
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0); // new sorted list
        ListNode curr = head;

        while (curr != null) {
            // At each iteration, we insert curr into the sorted part
            ListNode prev = dummy;

            // Find the right place to insert curr node
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Save the next node to be processed
            ListNode nextTemp = curr.next;

            // Insert current node between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node
            curr = nextTemp;
        }

        return dummy.next; // Return the sorted list
    }
}
