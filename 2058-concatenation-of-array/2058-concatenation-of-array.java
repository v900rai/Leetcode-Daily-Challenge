class Solution {
    public int[] getConcatenation(int[] nums) {
        // नई सरणी बनाना जिसमें nums की लंबाई का दोगुना स्थान हो
        int[] ans = new int[2 * nums.length]; 
        
        // nums को ans में दो बार कॉपी करना
        for(int i = 0; i < nums.length; i++){
            ans[i] = nums[i]; // पहली बार कॉपी करना
            ans[i + nums.length] = nums[i]; // दूसरी बार कॉपी करना
        }
        
        return ans; // परिणामी सरणी लौटाना
    }
}
