class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> freq = new HashMap<>();
        // Count frequency of each string
        for (String s : arr) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        // Traverse in original order and collect distinct strings
        int count = 0;
        for (String s : arr) {
            if (freq.get(s) == 1) {
                count++;
                if (count == k) {
                    return s;
                }
            }
        }

        return "";
    }
}