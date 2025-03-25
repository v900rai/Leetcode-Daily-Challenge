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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) 
        return null; // Edge case: खाली Linked List
        
        ListNode dummy = new ListNode(0); // Dummy Node बनाकर Edge Case संभालें
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Fast को n+1 steps आगे बढ़ाएं
        for (int i = 0; i <= n; i++) {
            if (fast != null) 
                fast = fast.next;
            else 
                return head; // Edge case: अगर n गलत हो (Linked List से बड़ा)
        }

        // Slow को सही position तक लाएं
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Target Node को हटाएं
        ListNode temp = slow.next;
        slow.next = slow.next.next;
        temp = null; // Memory cleanup

        return dummy.next; // नया Head लौटाएं
    }
}
