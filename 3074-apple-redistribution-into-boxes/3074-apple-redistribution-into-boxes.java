//T.C : O(n + m log m)
//S.C : O(1)
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        // Sort capacity in descending order
        Arrays.sort(capacity);
        int totalApple = 0;
        for (int a : apple) {
            totalApple += a;
        }

        int count = 0;
        int i = capacity.length - 1;

        while (totalApple > 0) {
            totalApple -= capacity[i];
            count++;
            i--;
        }

        return count; // total number of boxes used
    }
}



//Approach-2 (Using counting sort so that we can simply assign the apples to largest boxes first)
//T.C : O(n + m)