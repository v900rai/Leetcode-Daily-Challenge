class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0; // initial value of variable X

        // Loop through each operation in the array
        for (String operation : operations) {

            // If operation is a decrement type (--X or X--)
            if (operation.equals("--X") || operation.equals("X--")) {
                x--; // decrease the value of X by 1
            } 
            // Otherwise, it must be an increment type (++X or X++)
            else {
                x++; // increase the value of X by 1
            }
        }

        // Return the final value of X after all operations
        return x;
    }
}
