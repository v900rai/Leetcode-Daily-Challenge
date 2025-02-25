class Solution {
    public int numOfSubarrays(int[] nums) {
        int odd = 0;  // अब तक मिले विषम योग वाले prefix की संख्या
        int even = 1; // शुरू में 0 को भी एक सम (even) prefix मानेंगे
        int sum = 0;  // अब तक का योग
        int totalCount = 0; // विषम योग वाले subarrays की कुल संख्या
        int MOD = 1000000007; // परिणाम को सीमित करने के लिए

        for (int num : nums) {
            sum += num; // वर्तमान तक का prefix sum
            
            // यदि sum odd है, तो odd की संख्या बढ़ाएँ
            if (sum % 2 == 1) {
                totalCount = (totalCount + even) % MOD;
                odd++;  // यह sum अब odd prefixes में गिना जाएगा
            } else {
                totalCount = (totalCount + odd) % MOD;
                even++; // यह sum अब even prefixes में गिना जाएगा
            }
        }
        return totalCount;
    }
}
