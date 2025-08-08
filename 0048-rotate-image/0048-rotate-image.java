import java.util.ArrayList;
import java.util.List;

class Solution {
  public void rotate(int[][] arr) {
    int n = arr.length; // length of row or column;
    int left = 0; // for swapping of left column elements with right column elements
    int right = n - 1;

    // Step 1: Transpose the matrix (swap rows and columns)
   
    for(int i=0; i<n; i++){
      for(int j=i; j<n; j++){
        int temp=arr[i][j];
        arr[i][j]=arr[j][i];
        arr[j][i]=temp;
      }
    }

    // Step 2: Reverse each row (swap elements in the row)
    for (int i = 0; i < n; i++) {
      left = 0;
      right = n - 1;
      while (left < right) {
        int temp = arr[i][left];
        arr[i][left] = arr[i][right];
        arr[i][right] = temp;
        left++;
        right--;
      }
    }
  }
  
}
