class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length, n = strs[0].length(), res = 0;
        Set<Integer> inorder = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> tmp = new HashSet<>();
            boolean valid = true;
            for (int j = 1; j < m; j++) {
                if (inorder.contains(j-1)) continue;
                if (strs[j-1].charAt(i) < strs[j].charAt(i)) tmp.add(j-1);
                if (strs[j-1].charAt(i) > strs[j].charAt(i)) {
                    valid = false;
                    res++;
                    break;
                }
            }
            if (valid) inorder.addAll(tmp);
        }
        return res;
    }
}