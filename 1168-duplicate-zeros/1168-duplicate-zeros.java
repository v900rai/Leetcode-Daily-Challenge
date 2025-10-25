class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;
        
        // Step 1: Count how many zeros are present
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeros++;
            }
        }

        // Step 2: Start from the end and shift elements
        // i → pointer in original array
        // j → pointer in expanded array (with zeros duplicated)
        for (int i = n - 1; i >= 0; i--) {
            int j = i + zeros;  // new index after accounting for duplicated zeros
            
            // If new position is inside the array, copy element
            if (j < n) {
                arr[j] = arr[i];
            }

            // If element is zero, duplicate it
            if (arr[i] == 0) {
                zeros--; // one zero handled
                if (i + zeros < n) {
                    arr[i + zeros] = 0;
                }
            }
        }
    }
}
