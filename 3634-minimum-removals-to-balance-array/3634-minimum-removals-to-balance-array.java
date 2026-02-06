class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int n=nums.length;
        int count=0; 
        int j=0;
        while(i<n){
            while(j<n&&nums[i]>(long)nums[j]*k){
                j++;
            }
            count=Math.max(count,i-j+1);
            i++;
        }
        return n-count;
    }
}