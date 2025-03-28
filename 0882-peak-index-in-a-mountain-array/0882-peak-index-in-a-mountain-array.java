class Solution {
    public int peakIndexInMountainArray(int[] arr) {
      int left=0;
      int right=arr.length-1;
      while(left<=right){
        int mid=left+(right-left)/2;
        if(arr[mid-1]<arr[mid]&& arr[mid]>arr[mid+1])
        return mid;
        else if(arr[mid-1]<arr[mid])
        left=mid+1;
        else{
          right=mid;
        }
      }
      // this ie adage  cases 
      return -1;
      //this not execute 
        
    }
}