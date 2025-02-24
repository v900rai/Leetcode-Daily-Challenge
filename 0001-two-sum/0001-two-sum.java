class Solution {
    public int[] twoSum(int[] nums, int target) {
        // nums: इनपुट के रूप में दिया गया integer array  
        // target: वह संख्या जिसे हमें दो संख्याओं को जोड़कर प्राप्त करना है  
        int n = nums.length; // Array की लंबाई प्राप्त करना  

        // दो nested loops का उपयोग करके सभी संभावित जोड़ों की जाँच करना  
        for (int i = 0; i < n - 1; i++) { // पहले संख्या के लिए loop  
            for (int j = i + 1; j < n; j++) { // दूसरे संख्या के लिए loop  
                
                // यदि दो संख्याओं का योग target के बराबर है, तो उनकी indices return करें  
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j}; // दो indices वाले array को return करना  
                }
            }
        }
        
        // यदि कोई सही जोड़ा नहीं मिला तो null return करें  
        return null;
    }
}
