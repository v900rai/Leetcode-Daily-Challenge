

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        
        // Add all elements from nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }
        
        // Check for common elements in nums2
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }
        
        // Convert resultSet to an int array
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }
        
        return result;
    }
}
