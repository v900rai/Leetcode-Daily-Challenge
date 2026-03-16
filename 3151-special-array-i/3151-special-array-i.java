class Solution {
    public boolean isArraySpecial(int[] nums) {

        // Agar array me sirf 1 element hai to wo automatically special hoga
        if (nums.length == 1)
            return true;

        // Adjacent elements ka parity check karenge
        for (int i = 1; i < nums.length; i++) {

            // Agar current aur previous dono even ya dono odd hue
            // to array special nahi hai
            if (nums[i] % 2 == nums[i - 1] % 2)
                return false;
        }

        // Agar loop complete ho gaya, matlab sab adjacent pairs alternate parity me hain
        return true;
    }
}