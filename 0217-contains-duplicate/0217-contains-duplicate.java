class Solution {
    public boolean containsDuplicate(int[] nums) {
    //     Set<Integer> st = new HashSet<Integer>();
    //    for(int i=0; i<nums.length; i++){
    //     if(st.contains(nums[i])){
    //         return true;
    //     }
    //     st.add(nums[i]);
    //    }
    //    return false;


      Arrays.sort(nums); 
        for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i+1]) {
                    return true;
                }
        }
        return false;
    }
}