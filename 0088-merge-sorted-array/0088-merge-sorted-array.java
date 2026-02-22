class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // i -> nums1 ke valid elements ka last index
        int i = m - 1;

        // j -> nums2 ka last index
        int j = n - 1;

        // k -> nums1 ka total last index (m + n - 1)
        int k = m + n - 1;

        // Step 1: Jab tak dono arrays me elements hai
        while (i >= 0 && j >= 0) {

            // Compare karo dono arrays ke last elements
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];  // bada element last me daalo
                i--;
            } else {
                nums1[k] = nums2[j];  // bada element last me daalo
                j--;
            }
            k--;  // har baar k ko decrease karna hai
        }

        // Step 2: Agar nums2 me elements bach gaye
        // (nums1 ke bachne ki tension nahi leni)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}