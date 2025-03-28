class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int  right = arr.length - 1;

        while (left<right) {  // '=' लगाने की जरूरत नहीं है
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // Peak left side में हो सकती है, इसलिए r को mid पर ले आते हैं
                right = mid;
            } else {
                // Peak right side में हो सकती है
                left = mid + 1;
            }
        }

        return left;  // Left pointer ही peak index पर आ जाएगा
    }
}
