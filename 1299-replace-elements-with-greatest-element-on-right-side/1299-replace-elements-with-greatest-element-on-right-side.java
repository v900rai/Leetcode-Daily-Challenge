class Solution {

    public int[] replaceElements(int[] arr) {

        int n = arr.length;

        // Loop for every element
        for (int i = 0; i < n; i++) {

            int max = -1;

            // Find max element on right side
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }

            // Replace current element
            arr[i] = max;
        }

        return arr;
    }
}
