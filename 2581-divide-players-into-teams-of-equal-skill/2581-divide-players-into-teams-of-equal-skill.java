
import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        // Sort the skill array
        Arrays.sort(skill);
        long totalSum=0;
        int left=0;
        int right=skill.length-1;

        int  targetSum= skill[left]+ skill[right];
        while(left<right){
            int currentSum=skill[left]+skill[right];
           if (currentSum != targetSum){
                return -1;
            }
             totalSum  += (long) skill[left] * skill[right];

           
            left++;
            right--;
        }
        return totalSum;
       
    }
}
