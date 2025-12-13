class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }
        int max = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int count = 0;
                int curr = num;
                while(set.contains(curr)){
                    count++;
                    curr++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}