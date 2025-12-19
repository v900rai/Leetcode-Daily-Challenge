class Solution {
    public int[] twoSum(int[] numbers, int target) {

      int left =0;
      int right = numbers.length-1;
      while(left <right){
        int sum = numbers[left] + numbers[right];
        if(sum == target){
          return new int[] {left+1 , right+1};
        }
        if(sum<target){
          left++;
        }
        else{
          right--;
        }
      }
        return new int[] {-1,-1};
      }
    }

//         int left = 0;                     // Start pointer
//         int right = numbers.length - 1;   // End pointer

//         while (left < right) {

//             int sum = numbers[left] + numbers[right];

//             // If sum matches target
//             if (sum == target) {
//                 // Return 1-based index
//                 return new int[]{left + 1, right + 1};
//             }
//             // If sum is smaller, move left pointer
//             else if (sum < target) {
//                 left++;
//             }
//             // If sum is greater, move right pointer
//             else {
//                 right--;
//             }
//         }

//         // Problem guarantee solution exists
//         return new int[]{-1, -1};
//     }
// }
