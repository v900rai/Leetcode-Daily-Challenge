class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
      
      List<Integer> targetIndex = new ArrayList<>();
      Arrays.sort(nums);
      
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target) {
          targetIndex.add(i);
        }
      }
      return targetIndex;
    }
}