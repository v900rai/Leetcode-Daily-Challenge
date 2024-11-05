
//Approach-2 (Simple iterate and count and keep track)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int minChanges(String s) {
        int changes = 0;
        int n = s.length();

        for (int i = 0; i < n - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }

        return changes;
    }
}