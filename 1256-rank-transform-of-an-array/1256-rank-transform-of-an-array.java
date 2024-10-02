import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Create a copy of the array to sort it without modifying the original array
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // Use a HashMap to store the rank for each unique element
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        // Assign ranks to each element in the sorted array
        for (int num : sortedArr) {
            // If the element is not already in the map, assign it a rank
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }

        // Build the result array by replacing each element in the original array with its rank
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}
