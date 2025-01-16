class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int ans=0;
        if(n%2!=0){
            for(int num : nums2){
                ans^=num;
            }
        }
        int m=nums2.length;
        //int ans=0;
        if(m%2!=0){ 
            for(int num : nums1){
                ans^=num;
            }
        }
        return ans;
        
    }
}