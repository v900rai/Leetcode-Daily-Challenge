/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    public ListNode getIntersectionNode(ListNode a, ListNode b) {

        // If any list is empty
        if (a == null || b == null)
            return null;

        // Two pointers
        ListNode p1 = a;
        ListNode p2 = b;

        // Traverse until both pointers become equal
        while (p1 != p2) {

            // If p1 reaches end, move to list b
            p1 = (p1 == null) ? b : p1.next;

            // If p2 reaches end, move to list a
            p2 = (p2 == null) ? a : p2.next;
        }

        // Intersection node or null
        return p1;
    }
}