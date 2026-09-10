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

    private int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {

        // Base case
        if (root == null) {
            return new int[]{0, 0};
        }

        // Get left subtree sum and count
        int[] left = dfs(root.left);

        // Get right subtree sum and count
        int[] right = dfs(root.right);

        // Calculate current subtree sum
        int sum = left[0] + right[0] + root.val;

        // Calculate current subtree node count
        int count = left[1] + right[1] + 1;

        // Check average
        if (sum / count == root.val) {
            ans++;
        }

        // Return sum and count
        return new int[]{sum, count};
    }
} 