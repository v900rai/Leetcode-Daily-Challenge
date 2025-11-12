class Solution {
    public int gcd(int a,int b){
        if(b==0) return a;
       return gcd(b,a%b);
    }
    public int minOperations(int[] nums) {
        int count=0;
        for(int i:nums){
            if(i==1){
                count++;
            }
        }
        if(count>0){
            return nums.length-count;
        }
        else{
            int op=Integer.MAX_VALUE;
            for(int i=0;i<nums.length;i++){
                int val=nums[i];
                for(int j=i+1;j<nums.length;j++){
                    val=gcd(val,nums[j]);
                    if(val==1){
                        op=Math.min(j-i+1,op);
                        break;
                    }

                }
            }
            if(op!=Integer.MAX_VALUE) return op+nums.length-2;
        }
        return -1;
    }
}