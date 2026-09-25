class Solution {
    public int findDuplicate(int[] nums) {
    //   HashSet<Integer> has=new HashSet<>();
    //   for(int  num : nums){
    //     if(has.contains(num)){
    //       return num;
    //     }
    //     has.add(num);
    //   }
    //   return -1;
        
    // }

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return -1;
    }
}