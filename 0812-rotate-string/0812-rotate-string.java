class Solution {
    public boolean rotateString(String s, String goal) {
        // If the lengths are different, they can't be rotations of each other
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Concatenate s with itself and check if goal is a substring
        String doubled = s + s;
        return doubled.contains(goal);
        // vishal rai
    }
}
