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
// TC-O(N) SC-O(h) where h = height of the tree
class Solution {
    int height = 0;
    TreeNode ans;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // Step 1: find the height of the tree
        height = find_height(root);

        // Step 2: DFS to find the smallest subtree containing all deepest nodes
        dfs(root, 1);  // root node is at depth 1
        return ans;
    }

    // DFS to find the LCA of the deepest leaf nodes
    public boolean dfs(TreeNode node, int depth) {
        if (node == null) return false;

        // Current node is a deepest leaf
        if (depth == height) {
            ans = node;  // mark it as ans in case it's the only deepest node
            return true;  
        }

        boolean left = dfs(node.left, depth + 1);
        boolean right = dfs(node.right, depth + 1);

        // Current node has deepest nodes in both left and right subtree → LCA
        if (left && right) {
            ans = node;
            return true;
        }

        return left || right;  // deepest node is present in only one of the subtrees
    }

    // Function to compute height of the tree
    public int find_height(TreeNode node) {
        if (node == null) return 0;
        int left_height = find_height(node.left);
        int right_height = find_height(node.right);
        return Math.max(left_height, right_height) + 1;
    }
}

