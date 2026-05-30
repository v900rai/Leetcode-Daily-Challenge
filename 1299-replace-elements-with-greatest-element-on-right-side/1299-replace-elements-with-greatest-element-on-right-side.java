class Solution {

    public int[] replaceElements(int[] arr) {

        int n = arr.length;

        // Traverse each element of array
        for (int i = 0; i < n; i++) {

            // Assume maximum element on right side is -1
            int max = -1;

            // Find the maximum element on the right side of current index
            for (int j = i + 1; j < n; j++) {

                // Update max if bigger element is found
                if (arr[j] > max) {
                    max = arr[j];
                }
            }

            // Replace current element with right side maximum
            arr[i] = max;
        }

        // Return modified array
        return arr;
    }
}