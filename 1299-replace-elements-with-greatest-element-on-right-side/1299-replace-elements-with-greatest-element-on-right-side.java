class Solution {

  // Function to replace every element with the greatest element
  // among the elements to its right side
  public int[] replaceElements(int[] arr) {

    // max variable stores the maximum element seen so far from the right
    // Initially -1 because last element ka answer hamesha -1 hota hai
    int max = -1;

    // Traverse the array from right to left
    for (int i = arr.length - 1; i >= 0; i--) {

      // If current element is greater than max
      if (arr[i] > max) {

        // temp stores the old max value
        int temp = max;

        // Update max with current element
        max = arr[i];

        // Replace current element with previous max
        arr[i] = temp;

      } else {
        // If current element is smaller than max
        // Replace it directly with max
        arr[i] = max;
      }
    }

    // Return the modified array
    return arr;
  }
}
