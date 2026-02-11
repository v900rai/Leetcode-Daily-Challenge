class Solution {
    public int longestBalanced(int[] nums) {
        // we add each distinct in valid Segement
        // a valid Segement is the lastSeen[curr] + 1 --> currentt Index

        // its simple called as Prefix count
        // let the last index be n
        // Prefix[i] = carries diff(distinct odd ,distinct even) till n,
        // i.e ,[i ,n]

        // valid segement is balanced by addition of current element leads to ballancing any Prefix[i]
        // i.e : ballanced prefix[i] = 0 ,i.e prefix[i] = equall distinct even and odd ,diff = 0

        int siz = 0;
        for(int num : nums){
            siz = Math.max(siz ,num);
        }
        int ans = 0;
        int n = nums.length;
        int[] lastSeen = new int[siz+1];

        Arrays.fill(lastSeen ,-1);

        Segement seg = new Segement(n);

        for(int i = 0;i < n;i++){
            int val = nums[i] % 2 == 0 ? -1 : 1; // odd sign : 1 ,even sign : -1
            // first update the parity in the tree

            // the contribution of parity only contributes to the segements where nums[i] is not present
            // i.e segement : nums[lastSeen+1 : i]

            seg.update(0 ,n-1 ,0 ,lastSeen[nums[i]]+1 ,i ,val);
            // After the parity is upadated
            // we need the eariest index whose prefix[idx] = 0 ,that represents nums[idx : i] have equall number of even and odd

            int idx = seg.get(0 ,n-1 ,0 ,lastSeen[nums[i]]+1 ,i);
            if(idx != -1){
                ans = Math.max(i - idx + 1 ,ans);
            }
            lastSeen[nums[i]] = i;
        }

        return ans;
    }
}

// Segement tree construction
class Segement{
    int[] min;
    int[] max;
    int[] lazy;
    int n;

    public Segement(int n){
        this.n = n;

        min = new int[4*n];
        max = new int[4*n];
        lazy = new int[4*n];
    }

    public void update(int left ,int right ,int idx ,int qleft ,int qright ,int val){
        push(idx ,left ,right);

        // no overlap
        if(left > qright || right < qleft) return;

        // complete overlap
        if(left >= qleft && right <= qright){
            lazy[idx] += val;
            push(idx ,left ,right);

            return;
        }

        // partial overlap

        int mid = left + (right - left)/2;

        update(left ,mid ,2*idx+1 ,qleft ,qright ,val);
        update(mid+1 ,right ,2*idx+2 ,qleft ,qright ,val);

        min[idx] = Math.min(min[2*idx+1] ,min[2*idx+2]);

        max[idx] = Math.max(max[2*idx+1] ,max[2*idx+2]);
    }

    public void push(int idx ,int left ,int right){
        if(lazy[idx] == 0) return;

        min[idx] += lazy[idx];
        max[idx] += lazy[idx];

        if(left != right){
            lazy[2*idx+1] += lazy[idx];
            lazy[2*idx+2] += lazy[idx];
        }

        lazy[idx] = 0;
    }

    public int get(int left ,int right ,int idx ,int qleft ,int qright){
        push(idx ,left ,right);
        if(min[idx] > 0 || max[idx] < 0) return -1;

        // here we need to prune the seraching only the renge completely overlap or elese it may be a partial overlaping
        
        // here we are seraching for earliest index with prefix[idx] = 0
        // we are making a bidirectional binary seraching
        // we believe zero exist in our path only if min[idx] <= 0 && max[idx] >= 0
        
        // return case if our above bidirectional seach rule violates

        // if abouve cases are passed idx with prefix[0] ,nums[idx : i] have equall number of odd and even
        // will may be exists in the segement

        if(left == right) return left;

        int mid = left + (right - left)/2;
        int leftSub = get(left ,mid ,2*idx+1 ,qleft ,qright);

        if(leftSub != -1) return leftSub;

        return get(mid+1 ,right ,2*idx+2 ,qleft ,qright);

    }
}