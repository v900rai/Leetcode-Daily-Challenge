class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,n=nums.length,count=0,j=0;
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