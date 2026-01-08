class Solution {
    public static int[][]dp;
    public static int solve(int i,int j,int []nums1,int[]nums2){
             int n=nums1.length;
        int m=nums2.length;
    
        if(i>=n || j>=m)return Integer.MIN_VALUE;
        if(dp[i][j]!=Integer.MIN_VALUE)return dp[i][j];
        int product=nums1[i]*nums2[j];
        int include=product+Math.max(0,solve(i+1,j+1,nums1,nums2));
        int exclude1=solve(i+1,j,nums1,nums2);
        int exclude2=solve(i,j+1,nums1,nums2);
        return dp[i][j]=Math.max(include,Math.max(exclude1,exclude2));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
    
        int n=nums1.length;
        int m=nums2.length;
          dp=new int[n][m];
               for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
      int ans=    solve(0,0,nums1,nums2);
          return ans;

    }
}