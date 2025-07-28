class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Hindi: nums2 ke elements ko nums1 ke end mein copy karna
        // English: Copy elements from nums2 to the end of nums1
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        
        // Hindi: poori nums1 array ko sort karna
        // English: Sort the entire nums1 array
        Arrays.sort(nums1);
    }
}