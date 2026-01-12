class Solution {
    public int firstMissingPositive(int[] nums) {
        int max=0;
        int min=2;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            if(nums[i]>0){
                min=Math.min(min,nums[i]);
            }
            set.add(nums[i]);
        }

        if(min!=1){
            return 1;
        }

        for(int i=min;i<=max;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return max+1;
    }
}