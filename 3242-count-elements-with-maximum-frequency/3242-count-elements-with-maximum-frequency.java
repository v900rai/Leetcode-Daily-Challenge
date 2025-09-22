class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxval=0;
        for(int i=0; i<nums.length; i++){
            if(maxval <= nums[i]) maxval=nums[i];
        }
        int arr[]=new int[maxval+1];
        for(int i=0; i<nums.length; i++){
            int ele=nums[i];
            arr[ele]++;
        }
        int max=0, ans=0;
        for(int i=0; i<arr.length; i++){
            if(max <= arr[i]) max=arr[i]; 
        }
        for(int i=0; i<arr.length; i++){
            if(max == arr[i]) ans+=arr[i];
        }
        return ans;
    }
}