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
        ListNode dummy = new ListNode(0); // डमी नोड (Dummy node)
        dummy.next = head;
        
        ListNode first = dummy; // पहला पॉइंटर (First pointer)
        ListNode second = dummy; // दूसरा पॉइंटर (Second pointer)
        
        // पहले पॉइंटर को n+1 स्थान आगे ले जाएं (Move first pointer n+1 steps ahead)
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        
        // दोनों पॉइंटरों को एक साथ आगे बढ़ाएं (Move both pointers together)
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // nth नोड को हटाएं (Remove nth node)
        second.next = second.next.next;
        
        return dummy.next; // नया हेड (New head)
    }
}