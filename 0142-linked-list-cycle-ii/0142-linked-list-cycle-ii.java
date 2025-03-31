/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode kachua=head;
        ListNode khargosh=head;
        ListNode bunty=head;
        while(khargosh!=null && khargosh.next!=null){
            kachua=kachua.next;
            khargosh=khargosh.next.next;
            if(kachua== khargosh){
                while(bunty !=kachua){
                    kachua=kachua.next;
                    bunty=bunty.next;
                }
                return bunty;
            }
        }
        return null;
        
    }
}