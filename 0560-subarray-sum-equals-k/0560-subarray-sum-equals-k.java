class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        // बाहरी लूप सभी संभावित उपसरणी (subarray) की शुरुआत को दर्शाता है
        for (int i = 0; i < n; i++) {
            int sum = 0;

            // आंतरिक लूप i से शुरू होने वाली सभी उपसरणियों का योग निकालता है
            for (int j = i; j < n; j++) {
                sum += nums[j]; // वर्तमान उपसरणी का योग
                
                // यदि योग k के बराबर है, तो उपसरणी की गणना करें
                if (sum == k) {
                    count++;
                }
            }
        }
        return count; // कुल उपसरणी की संख्या लौटाएँ जिनका योग k है
    }
}
