class Solution {
    public boolean rotateString(String s, String goal) {

        // Step 1: Length check
        // Agar dono strings ki length same nahi hai,
        // to rotation possible hi nahi hai
        if(goal.length() != s.length())
            return false;
        
        // Step 2: Double the string
        // s + s karne se saare possible rotations cover ho jaate hain
        // Example: "abcde" -> "abcdeabcde"
        String temp = s + s;

        // Step 3: Check if goal is substring of temp
        // Agar goal, temp ke andar mil jata hai,
        // iska matlab goal ek rotation hai s ka
        if(temp.indexOf(goal) != -1)
            return true;

        // Agar substring nahi mila
        return false;
    }
}