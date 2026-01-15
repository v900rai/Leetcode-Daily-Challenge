class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //  Count frequency
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        //  Min heap based on frequency
        PriorityQueue<Integer> heap =
            new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        // Keep only k most frequent elements
        Object[] keys = freq.keySet().toArray();
        for (int i = 0; i < keys.length; i++) {
            int num = (int) keys[i];
            heap.add(num);

            if (heap.size() > k) {
                heap.poll();   // remove least frequent
            }
        }

        // Prepare result
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }

        return result;
    }
}