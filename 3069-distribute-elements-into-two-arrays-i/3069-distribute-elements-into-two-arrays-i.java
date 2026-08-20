class Solution {

    public int[] resultArray(int[] nums) {

        int n = nums.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        // First element goes to arr1
        arr1[0] = nums[0];

        // Second element goes to arr2
        arr2[0] = nums[1];

        int i = 0; // last index of arr1
        int j = 0; // last index of arr2

        // Start from third element
        for (int k = 2; k < n; k++) {

            // Compare last elements
            if (arr1[i] > arr2[j]) {

                // Add nums[k] to arr1
                i++;
                arr1[i] = nums[k];

            } else {

                // Add nums[k] to arr2
                j++;
                arr2[j] = nums[k];
            }
        }

        // Append arr2 to arr1
        for (int k = 0; k <= j; k++) {

            i++;
            arr1[i] = arr2[k];
        }

        return arr1;
    }
}