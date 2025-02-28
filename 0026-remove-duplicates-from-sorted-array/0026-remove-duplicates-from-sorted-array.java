class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) 
        return 0; // अगर array खाली है, तो return 0
        
        int count = 1; // पहला एलिमेंट हमेशा unique रहेगा
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // जब नया unique element मिले
                nums[count] = nums[i]; // उसे सही position पर रखें
                count++; // count को बढ़ाएं
            }
        }
        
        return count; // unique elements की संख्या return करें
    }
}
