class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        // Jab tak left != right, right-shift karte raho
        while(left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        // jitne shift kiye, utne left shift kar do
        return left << shift;
    }
}
