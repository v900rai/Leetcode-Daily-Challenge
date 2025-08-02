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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) 
        return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        // जब तक वे इंटरसेक्ट नहीं करते (Until they intersect)
        while (a != b) {
            // अगर एक लिस्ट खत्म हो जाए, दूसरी के हेड पर शुरू करें
            // (If one list ends, start from head of other)
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        
        return a; // इंटरसेक्शन पॉइंट या null (Intersection point or null)
    }
}