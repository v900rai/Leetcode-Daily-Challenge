class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        int n = blocks.size();
        int i = 0;
        int j = 0;
        int result = k;
        int W      = 0;

        while(j < n) {
            if(blocks[j] == 'W') {
                W++;
            }

            if(j - i + 1 == k) {
                result = min(result, W);

                if(blocks[i] == 'W') {
                    W--;
                }

                i++;
            }

            j++;
        }

        return result;
    }
};