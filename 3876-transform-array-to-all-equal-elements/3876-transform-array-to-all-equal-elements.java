class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        return make(nums,-1,k)||make(nums,1,k);
    }
    private boolean make(int[] nums,int num,int k){
        int i=0,temp=k;
        int[] copy=nums.clone();
        while(i<nums.length && nums[i]==num) i++;
        for(int j=i;j<nums.length-1;j++){
            if(copy[j]!=num && temp>0){
                copy[j]*=-1;
                copy[j+1]*=-1;
                temp--;
            }
        }
        for(i=0;i<nums.length;i++){
            if(copy[i]!=num) return false;
        }
        return true;
    }
}