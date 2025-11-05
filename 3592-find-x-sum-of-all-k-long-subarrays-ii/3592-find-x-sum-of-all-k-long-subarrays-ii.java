class Solution {
   private static class Node {
        int val;
        int freq;
        boolean inTop;
        Node(int v) { val = v; freq = 0; inTop = false; }
    }

    public long[] findXSum(int[] nums, int k, int x) {
         int n = nums.length;
        long[] ans = new long[n - k + 1];
        Comparator<Node> comp = (a, b) -> {
            if (a.freq != b.freq) return b.freq - a.freq;
            return b.val - a.val;
        };

        TreeSet<Node> top = new TreeSet<>(comp);
        TreeSet<Node> rest = new TreeSet<>(comp);
        Map<Integer, Node> map = new HashMap<>();
        long sumTop = 0;

        for (int i = 0; i < n; ++i) {
            int vAdd = nums[i];
            Node nodeAdd = map.get(vAdd);
            if (nodeAdd == null) {
                nodeAdd = new Node(vAdd);
                map.put(vAdd, nodeAdd);
            } else {
                if (nodeAdd.inTop) {
                    top.remove(nodeAdd);
                    sumTop -= (long) nodeAdd.val * nodeAdd.freq;
                    nodeAdd.inTop = false;
                } else {
                    rest.remove(nodeAdd);
                }
            }
            nodeAdd.freq++;
            rest.add(nodeAdd);

            if (i >= k) {
                int vRem = nums[i - k];
                Node nodeRem = map.get(vRem);
                if (nodeRem.inTop) {
                    top.remove(nodeRem);
                    sumTop -= (long) nodeRem.val * nodeRem.freq;
                    nodeRem.inTop = false;
                } else {
                    rest.remove(nodeRem);
                }
                nodeRem.freq--;
                if (nodeRem.freq == 0) map.remove(vRem);
                else rest.add(nodeRem);
            }

            while (top.size() < x && !rest.isEmpty()) {
                Node cand = rest.first();
                rest.remove(cand);
                cand.inTop = true;
                top.add(cand);
                sumTop += (long) cand.val * cand.freq;
            }

            while (!rest.isEmpty() && !top.isEmpty()) {
                Node bestRest = rest.first();
                Node worstTop = top.last();
                if (comp.compare(bestRest, worstTop) < 0) {
                    rest.remove(bestRest);
                    top.remove(worstTop);
                    sumTop -= (long) worstTop.val * worstTop.freq;
                    sumTop += (long) bestRest.val * bestRest.freq;
                    bestRest.inTop = true;
                    worstTop.inTop = false;
                    top.add(bestRest);
                    rest.add(worstTop);
                } else break;
            }

            if (i >= k - 1) ans[i - k + 1] = sumTop;
        }

        return ans;
    }
}