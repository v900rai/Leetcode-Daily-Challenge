class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int left = 0;    // Left pointer (window की शुरुआत को track करने के लिए)
        int zeros = 0;   // Window में कितने zeros हैं, इसे count करने के लिए
        int ans = 0;     // Final answer (longest subarray length)

        // Right pointer से पूरे array को traverse करेंगे
        for (int right = 0; right < n; right++) {
            
            // अगर current element zero है तो zeros count बढ़ा दो
            if (nums[right] == 0) {
                zeros++;
            }

            // Condition: subarray में ज्यादा से ज्यादा 1 zero allow है
            // अगर zeros > 1 हो जाए तो left pointer move करो
            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;   // अगर left वाला element zero है तो count कम करो
                }
                left++;   // Window को shrink करो
            }

            // यहाँ पर (right - left + 1) subarray की length है
            // लेकिन क्योंकि हमें एक element delete करना ही है (zero),
            // इसलिए "- zeros" किया गया है
            ans = Math.max(ans, right - left + 1 - zeros);
        }

        // Edge case: अगर पूरा array 1s है तो हमें एक element हटाना ही होगा,
        // इसलिए final answer (n - 1) होगा
        return (ans == n) ? ans - 1 : ans;
    }
}
