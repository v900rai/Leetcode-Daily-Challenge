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
    // Public method to start the recursion with full range
    public boolean isValidBST(TreeNode root) {
        // Use long instead of int to handle edge values safely
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return isValidBSTHelper(root, min, max);
    }

    // Helper method that checks the BST validity recursively
    public boolean isValidBSTHelper(TreeNode root, long min, long max) {
        // Base case: null node is always valid
        if (root == null)
            return true;

        // If node's value violates the min/max constraint, it's not a BST
        if (root.val <= min || root.val >= max)
            return false;

        // Recursively validate left and right subtrees with updated ranges
        return isValidBSTHelper(root.left, min, root.val) &&
               isValidBSTHelper(root.right, root.val, max);
    }
}
