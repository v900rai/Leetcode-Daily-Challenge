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
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Create a HashSet to store the elements of nums for quick lookup
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // Create a dummy node to handle edge cases (e.g., head node being deleted)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Traverse the list and remove nodes present in the nums array
        while (current.next != null) {
            if (numSet.contains(current.next.val)) {
                // Skip the node if its value is in the nums array
                current.next = current.next.next;
            } else {
                // Move to the next node if not removing the current node
                current = current.next;
            }
        }

        // Return the modified list, starting from dummy's next node
        return dummy.next;
    }
}
