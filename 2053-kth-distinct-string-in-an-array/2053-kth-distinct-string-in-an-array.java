class Solution {
    public String kthDistinct(String[] arr, int k) {

        // Step 1: Create a HashMap to store frequency
        Map<String, Integer> freq = new HashMap<>();

        // Step 2: Count frequency of each string
        for (String s : arr) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        // Step 3: Traverse array in original order
        int count = 0;

        for (String s : arr) {

            // Check if string is distinct (frequency = 1)
            
                if(freq.get(s) == 1){
                  count++;
                

                // If we found k-th distinct string
                if (count == k) {
                    return s;
                }
            }
        }

        // Step 4: If not found, return empty string
        return "";
    }
}