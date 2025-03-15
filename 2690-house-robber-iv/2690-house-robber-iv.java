class Solution {
    private boolean isPossible(int[] nums, int mid, int k) {
        int house = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                house++;
                i++; // skipping adjacent house
            }
        }
        
        return house >= k; // we managed to rob at least k houses
    }
    
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        
        int l = Arrays.stream(nums).min().getAsInt();
        int r = Arrays.stream(nums).max().getAsInt();
        
        int result = r;
        
        while (l <= r) { // O(log(maxC) * n )
            int mid = l + (r - l) / 2; // capability
            
            if (isPossible(nums, mid, k)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return result;
    }
}