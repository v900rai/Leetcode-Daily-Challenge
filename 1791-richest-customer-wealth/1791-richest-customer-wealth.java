class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum = 0;
        int max = 0;
        int n = accounts.length;
        for(int rows = 0; rows < n; rows++){
           sum = 0;
            for(int cols = 0; cols < accounts[rows].length; cols++){
                sum += accounts[rows][cols];
            }
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}