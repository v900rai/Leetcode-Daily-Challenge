class Solution {
    public int longestConsecutive(int[] arr) {
       
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            // Check if this is the start of a sequence
            if (!set.contains(arr[i] - 1)) {
                int val = arr[i];
                while (set.contains(val)) {
                    val++;
                }
                ans = Math.max(ans, val - arr[i]);
            }
        }
        return ans;
    }
}