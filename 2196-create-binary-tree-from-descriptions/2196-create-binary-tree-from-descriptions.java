/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] d) {
        Map<Integer, TreeNode> m = new HashMap<>();
        Set<Integer> c = new HashSet<>();
        for (int[] v : d) {
            m.putIfAbsent(v[0], new TreeNode(v[0]));
            m.putIfAbsent(v[1], new TreeNode(v[1]));
            if (v[2] == 1) m.get(v[0]).left  = m.get(v[1]);
            else           m.get(v[0]).right = m.get(v[1]);
            c.add(v[1]);
        }
        for (int x : m.keySet())
            if (!c.contains(x)) return m.get(x);
        return null;
    }
}