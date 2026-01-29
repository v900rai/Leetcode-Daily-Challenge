class Solution {
    public int secondHighest(String s) {
        int maxElement = -1;
        int secondMaxElement = -1;
        
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
    
            if(c >= '0' && c <= '9'){
               int digit = c - '0';

               if(maxElement < 0){
                maxElement = digit;
               }

               if(maxElement < digit) {
                secondMaxElement = maxElement;
                maxElement = digit;
               }else if (maxElement > digit && secondMaxElement < digit) {
                secondMaxElement = digit;
               }

            }
        }
        return secondMaxElement;

    }
}