import java.util.*;

class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Store reserved seats row-wise
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {

            int row = seat[0];
            int column = seat[1];

            map.computeIfAbsent(row, k -> new HashSet<>())
               .add(column);
        }

        // Rows without any reserved seats
        // can accommodate 2 families each
        int answer = (n - map.size()) * 2;

        // Check rows having reserved seats
        for (Set<Integer> reserved : map.values()) {

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            // Check seats 2,3,4,5
            for (int seat = 2; seat <= 5; seat++) {
                if (reserved.contains(seat)) {
                    left = false;
                    break;
                }
            }

            // Check seats 4,5,6,7
            for (int seat = 4; seat <= 7; seat++) {
                if (reserved.contains(seat)) {
                    middle = false;
                    break;
                }
            }

            // Check seats 6,7,8,9
            for (int seat = 6; seat <= 9; seat++) {
                if (reserved.contains(seat)) {
                    right = false;
                    break;
                }
            }

            // Both left and right are available
            if (left && right) {
                answer += 2;
            }

            // Either left or middle OR right is available
            else if (left || middle || right) {
                answer += 1;
            }
        }

        return answer;
    }
}