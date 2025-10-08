class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=spells.length;
        int m=potions.length,j=0;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int count=0,left=0,right=m-1;
            while(left<=right){
                int mid=(left + right)>>1;
                if((long)potions[mid]*spells[i]>=success){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            count=m-left;
            ans[i]=count;
        }
        return ans;
    }
}