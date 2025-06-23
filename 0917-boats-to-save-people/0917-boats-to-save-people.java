class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0; // Initialize boat count
        Arrays.sort(people); // Sort the array in ascending order
        
        int left = 0; // Pointer for the lightest person
        int right = people.length - 1; // Pointer for the heaviest person
        
        while (left <= right) {
            // Check if the lightest and heaviest can share a boat
            if ((people[right] + people[left]) <= limit) {
                left++; // Move to the next lightest person
            }
            right--; // Always move the heaviest person pointer
            boats++; // Increment boat count for each pair or single
        }
        return boats;
    }
}