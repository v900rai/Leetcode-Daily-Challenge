class Solution {
    public int heightChecker(int[] height) {
        int expected[]=height.clone();
        Arrays.sort(expected);
        int count=0;
        for(int i=0; i<expected.length; i++){
            if(expected[i]!=height[i]){
                count++;

            }
        }
        return count ;
        
    }
}