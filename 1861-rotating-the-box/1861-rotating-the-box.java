class Solution {
    public char[][] rotateTheBox(char[][] box) {

        // Number of rows
        int row = box.length;

        // Number of columns
        int col = box[0].length;

        // New matrix after rotation
        char[][] box_90 = new char[col][row];

        // -----------------------------
        // STEP 1 : Simulate Gravity
        // -----------------------------

        for (int i = 0; i < row; i++) {

            // cell points to the position
            // where next stone '#' should fall
            int cell = col - 1;

            // Traverse row from right to left
            for (int j = col - 1; j >= 0; j--) {

                // If obstacle found
                if (box[i][j] == '*') {

                    // Stone cannot cross obstacle
                    // So next available cell becomes left side
                    cell = j - 1;
                }

                // If stone found
                else if (box[i][j] == '#') {

                    // Remove current stone
                    box[i][j] = '.';

                    // Place stone at correct falling position
                    box[i][cell] = '#';

                    // Move cell left
                    cell--;
                }
            }
        }

        // -----------------------------
        // STEP 2 : Rotate 90 Degree
        // -----------------------------

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                // Rotate clockwise
                box_90[j][row - i - 1] = box[i][j];
            }
        }

        return box_90;
    }
}