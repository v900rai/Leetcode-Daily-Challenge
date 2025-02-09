
   class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0]; // पहले एलिमेंट को मेजॉरिटी मानते हैं
        int count = 1; // काउंट शुरू में 1 रखते हैं
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++; // अगर वही संख्या मिली तो काउंट बढ़ाएँ
            } else {
                count--; // अन्यथा काउंट घटाएँ
                if (count == 0) {
                    candidate = nums[i]; // नया संभावित मेजॉरिटी एलिमेंट सेट करें
                    count = 1;
                }
            }
        }
        
        return candidate; // मेजॉरिटी एलिमेंट लौटाएँ
    }
}
