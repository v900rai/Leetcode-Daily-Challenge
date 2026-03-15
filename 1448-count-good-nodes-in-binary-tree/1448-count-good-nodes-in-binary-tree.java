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
    public int goodNodes(TreeNode root) {
        // Start DFS traversal with root value as the maximum seen so far
        return countGoodNodes(root, root.val);
    }

    public int countGoodNodes(TreeNode node, int maxSoFar) {
        // Base case: if node is null, no good node
        if (node == null) {
            return 0;
        }

        // Check if current node is a good node
        int count = 0;
        if (node.val >= maxSoFar) {
            count = 1;
        }

        // Update maximum value seen so far in this path
        maxSoFar = Math.max(maxSoFar, node.val);

        // Recursively count in left and right subtree
        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);

        return count;
    }
}