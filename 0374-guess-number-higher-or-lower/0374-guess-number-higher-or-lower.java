/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int  right = n;
        
        while (left <= right) { // Condition changed from left < right to left <= right
            int guess_no = left + (right - left) / 2;
            int val = guess(guess_no);
            
            if (val == 0) {
                return guess_no;
            } else if (val == -1) {
                right = guess_no - 1; // Move left
            } else {
                left = guess_no + 1;  // Move right
            }
        }
        
        return -1; // Should never reach here if input constraints are valid
    }
}
