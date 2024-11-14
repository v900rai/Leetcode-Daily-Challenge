import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        // Iterate through all possible hours and minutes
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                // Check if the number of 1s in the binary representation matches turnedOn
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    // Format the time as "H:MM"
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }

        return result;
    }
}
