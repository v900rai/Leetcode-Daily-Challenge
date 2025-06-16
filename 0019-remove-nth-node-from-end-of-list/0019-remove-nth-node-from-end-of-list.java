class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize two pointers, fast and slow, both starting at the head of the list
        ListNode fast = head;
        ListNode slow = head;

        // Move the fast pointer n nodes ahead to create a gap of n nodes between fast and slow
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast becomes null after moving n nodes, it means the node to be removed is the head
        // So, return head.next (skip the head node)
        if (fast == null) {
            return head.next;
        }

        // Move both pointers until fast reaches the last node (fast.next == null)
        // At this point, slow will be pointing to the node just before the node to be removed
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end by skipping it (slow.next = slow.next.next)
        slow.next = slow.next.next;

        // Return the head of the modified list
        return head;
    }
}