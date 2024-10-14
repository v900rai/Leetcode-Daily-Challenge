import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long maxKelements(int[] nums, int k) {
        // Max-Heap to store the elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Insert all elements into the max-heap
        for (int num : nums) {
            maxHeap.add(num);
        }
        
        long score = 0;
        
        // Perform 'k' operations
        for (int i = 0; i < k; i++) {
            // Extract the maximum element
            int max = maxHeap.poll();
            
            // Add it to the score
            score += max;
            
            // Replace the max element with its ceiling of one third
            int reduced = (int) Math.ceil(max / 3.0);
            
            // Add the reduced value back to the heap
            maxHeap.add(reduced);
        }
        
        // Return the total score
        return score;
    }
}
