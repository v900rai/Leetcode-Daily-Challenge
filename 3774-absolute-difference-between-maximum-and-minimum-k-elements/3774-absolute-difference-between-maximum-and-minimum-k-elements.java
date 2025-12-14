class Solution {
    public int absDifference(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        if(n==1) 
        return 0;
        int sum1 = 0;
        int sum2 = 0;
        for(int i=n-1;i>=n-k;i--){
            
            sum1=sum1+arr[i];
        }
        for(int i=0;i<k;i++){
            sum2 += arr[i];
        }
        return Math.abs(sum1-sum2);
    }
}