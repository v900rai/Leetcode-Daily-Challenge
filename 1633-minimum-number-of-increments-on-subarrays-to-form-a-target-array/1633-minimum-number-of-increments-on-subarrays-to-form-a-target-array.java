class Solution {
    public int minNumberOperations(int[] target) {
        int ans = target[0];  // पहला element तक पहुँचने के लिए इतने increments चाहिए
        for(int i = 1; i < target.length; i++) {
            if(target[i] > target[i-1])
                ans += target[i] - target[i-1]; // जब अगला element बड़ा हो, तो extra increments चाहिए
        }
        return ans;
    }
}
