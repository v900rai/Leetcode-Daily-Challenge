import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        // Sort asteroids in increasing order
        Arrays.sort(asteroids);

        // Use long to avoid integer overflow
        long currentMass = mass;

        // Traverse all asteroids
        for (int asteroid : asteroids) {

            // If current mass is smaller,
            // we cannot destroy this asteroid
            if (currentMass < asteroid) {
                return false;
            }

            // Destroy asteroid and increase mass
            currentMass += asteroid;
        }

        // Successfully destroyed all asteroids
        return true;
    }
}