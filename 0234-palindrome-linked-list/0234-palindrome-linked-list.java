class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        // मध्य नोड ढूंढें (Find middle)
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // दूसरी आधी लिस्ट को रिवर्स करें (Reverse second half)
        ListNode prev = null;
        ListNode current = slow;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        // दोनों हिस्सों की तुलना करें (Compare both halves)
        ListNode first = head;
        ListNode second = prev;
        
        while (second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        
        return true;
    }
}