class Solution {
    class Pair {
        int freq;
        int val;
        public Pair(int freq, int val) {
            this.freq = freq;
            this.val = val;
        }
    }
    
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            // Build frequency map for current window
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }
            
            // Priority queue: sort by frequency (descending), then by value (descending)
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
                if (a.freq != b.freq) {
                    return b.freq - a.freq; // Higher frequency first
                }
                return b.val - a.val; // Higher value first (tie-breaker)
            });
            
            // Add all elements to priority queue
            for (int key : map.keySet()) {
                pq.offer(new Pair(map.get(key), key));
            }
            
            // Sum top x elements (value * frequency for each)
            int sum = 0;
            int count = Math.min(x, pq.size()); // Handle case where distinct elements < x
            for (int j = 0; j < count; j++) {
                Pair p = pq.poll();
                sum += p.val * p.freq; // Sum all occurrences: value * frequency
            }
            
            ans[i] = sum;
        }
        
        return ans;
    }
}