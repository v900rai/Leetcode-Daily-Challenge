class Solution {
    public int firstMissingPositive(int[] nums) {

        int max = 0;          // array ka maximum value store karega
        int min = 2;          // minimum positive number (initial 2 rakha)
        
        HashSet<Integer> set = new HashSet<>();

        // Step 1: max, min aur set fill karna
        for (int i = 0; i < nums.length; i++) {

            // max value update
            max = Math.max(max, nums[i]);

            // sirf positive numbers ke liye min update
            if (nums[i] > 0) {
                min = Math.min(min, nums[i]);
            }

            // har element set me add
            set.add(nums[i]);
        }

        // Step 2: agar 1 hi missing hai
        if (min != 1) {
            return 1;
        }

        // Step 3: min se max tak missing number dhoondo
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                return i;   // pehla missing positive
            }
        }

        // Step 4: agar kuch bhi missing nahi mila
        return max + 1;
    }
}
