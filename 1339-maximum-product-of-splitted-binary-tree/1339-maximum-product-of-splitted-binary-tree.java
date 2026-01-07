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
    final int mod = (int)1e9 + 7;
    
    public int maxProduct(TreeNode root) {
        // calculate sum of subtree from each node
        int totalSum = treeSum(root);
        long ans = removeEdge(root, totalSum);
        return (int)(ans % mod);
    }

    private long removeEdge(TreeNode parent, int totalSum){
        if(parent == null) return 0;

        // Calculate product for split at this node first
        long max = Integer.MIN_VALUE;

        // remove left edge if it exists
        if(parent.left != null){
            long remove = parent.left.val;
            long leftProd = remove * (totalSum - remove);

            max = Math.max(max, leftProd);
        }
        
        // remove right edge if it exists
        if(parent.right != null){
            long remove = parent.right.val;
            long rightProd = remove * (totalSum - remove);

            max = Math.max(max, rightProd);
        }

        // Also consider contribution of subtrees, they might get higher product from edge removal
        max = Math.max(max, removeEdge(parent.left, totalSum));
        max = Math.max(max, removeEdge(parent.right, totalSum));

        return max;
    }

    private int treeSum(TreeNode node){
        if(node == null) return 0;

        int sum = treeSum(node.left);
        sum += treeSum(node.right);
        sum += node.val;
        return node.val = sum;
    }
}