class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
      
    
        int windowSum = 0;
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];          // add right element

            if (i >= k - 1) {             // window size k reached
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[i - (k - 1)]; // remove left element
            }
        }
        return maxSum;
    }
}

    
