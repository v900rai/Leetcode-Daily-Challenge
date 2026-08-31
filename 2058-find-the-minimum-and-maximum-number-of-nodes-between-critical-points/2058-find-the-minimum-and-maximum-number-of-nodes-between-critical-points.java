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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};
        
        List<Integer> critical_points = new ArrayList<>();
        
        ListNode curr = head;
        
        ListNode prev = new ListNode();
        prev.next = curr;
        
        int index = 1;
        while(curr.next != null){
            if(index != 1){
                if((curr.val > prev.val && curr.val > curr.next.val) || 
                    (curr.val < prev.val && curr.val < curr.next.val))
                    critical_points.add(index);
            }
            index++;
            curr = curr.next;
            prev = prev.next;
        }
        
        if(critical_points.size() <= 1)
            return new int[]{-1,-1};
        
        Collections.sort(critical_points);
        
        int max_distance = critical_points.get(critical_points.size()-1) - critical_points.get(0);
        
        int min_distance = Integer.MAX_VALUE;
        
        for(int i=0; i<critical_points.size()-1; i++){
            min_distance = Math.min(min_distance, critical_points.get(i+1) - critical_points.get(i));
        }
        
        return new int[]{min_distance,max_distance};
    }
}