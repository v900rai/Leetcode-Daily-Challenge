
import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        int mid=n/2;
        long largerSum=0;
        long smallerSum=0;
        long[] arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=Math.abs(nums[i]);
        }
        Arrays.sort(arr);
        for(int i=0;i<mid;i++){
            smallerSum+=arr[i]*arr[i];
        }
        for(int i=mid;i<n;i++){
            largerSum+=arr[i]*arr[i];
        }
        return largerSum-smallerSum;
    }
}