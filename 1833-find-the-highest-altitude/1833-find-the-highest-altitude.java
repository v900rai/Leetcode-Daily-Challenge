class Solution {
    public int largestAltitude(int[] gain) {
    //   int sum=0;
    //   int max=0;
    //   for(int i=0; i<gain.length; i++){
    //     sum=sum+gain[i];
    //     max=Math.max(max,sum);

    //   }
    //   return max;


  
        int currentAltitude = 0;  // Tracks the current altitude
        int highestAltitude = 0;  // Tracks the highest altitude reached

        for (int change : gain) {
            currentAltitude += change;  // Update the current altitude
            highestAltitude = Math.max(highestAltitude, currentAltitude);  // Update the highest altitude if needed
        }

        return highestAltitude;  // Return the maximum altitude reached
    


    }
}