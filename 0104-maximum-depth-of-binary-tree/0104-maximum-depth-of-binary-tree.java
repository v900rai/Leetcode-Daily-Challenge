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
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int maxDepth(TreeNode root) {
        // यदि root null है, तो गहराई (depth) 0 होगी
        if (root == null) {
            return 0;
        }

        // बाएं सबट्री (left subtree) की अधिकतम गहराई निकालें
        int leftMax = maxDepth(root.left);

        // दाएं सबट्री (right subtree) की अधिकतम गहराई निकालें
        int rightMax = maxDepth(root.right);

        // दोनों में से अधिकतम चुनकर 1 जोड़ें (क्योंकि करंट नोड भी शामिल है)
        return Math.max(leftMax, rightMax) + 1;
    }
}
