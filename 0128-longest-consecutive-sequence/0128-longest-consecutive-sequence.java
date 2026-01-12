class Solution {
    public int longestConsecutive(int[] nums) {

        // Step 1: Sabhi elements ko HashSet me daal do
        // Taaki O(1) time me search ho sake
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }

        int max = 0; // Longest sequence ka answer

        // Step 2: Har number ke liye check karo
        for(int num : set){

            // Agar num-1 present nahi hai,
            // iska matlab yeh sequence ka starting point hai
            if(!set.contains(num - 1)){

                int count = 0;     // current sequence length
                int curr = num;    // current number

                // Step 3: Consecutive numbers count karo
                while(set.contains(curr)){
                    count++;
                    curr++;
                }

                // Step 4: Max length update karo
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
