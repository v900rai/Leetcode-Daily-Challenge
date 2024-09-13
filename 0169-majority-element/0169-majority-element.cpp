class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int candidate = 0;
        int rai = 0;

        
        for (int i = 0; i < nums.size(); i++) {
            if (rai == 0) {
                candidate = nums[i];
                rai = 1;
            } else if (candidate == nums[i]) {
                rai++;
            } else {
                rai--;
            }
        }

        return candidate;
    }
};
