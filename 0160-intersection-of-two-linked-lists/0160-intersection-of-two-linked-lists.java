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
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int a = 0;
        int b = 0;
        
        while (curr != null) {
            a++;
            curr = curr.next;
        }
        
        curr = headB;
        while (curr != null) {
            b++;
            curr = curr.next;
        }
        
        int diff = Math.abs(a - b);
        
        if (a < b) {
            while (diff-- > 0) {
                headB = headB.next;
            }
        } else {
            while (diff-- > 0) {
                headA = headA.next;
            }
        }
        
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}
