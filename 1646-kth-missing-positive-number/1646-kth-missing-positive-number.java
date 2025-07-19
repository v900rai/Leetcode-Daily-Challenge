class Solution {
    public int findKthPositive(int[] arr, int k) {
      int left =0; 
      int right=arr.length-1;
      while(left<=right){
        int mid=right+(left-right)/2;
        int missingNumber=arr[mid]-mid-1;
        if(missingNumber<k){
          left=mid+1;
        }
        else {
          right=mid-1;
        }
      }
    
        // Return the k-th missing number
        return k + left;
        
    }
}