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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1; // अगर -1 आया तो unbalanced, वरना balanced
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0; // null नोड की ऊँचाई 0 होती है
        }

        // बाएं और दाएं सब-ट्री की ऊँचाई निकालें
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // अगर किसी भी subtree से -1 मिला, तो ट्री unbalanced है
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        // अगर ऊँचाई का अंतर 1 से अधिक है, तो ट्री unbalanced है
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // वरना, करंट नोड की ऊँचाई = 1 + अधिकतम(leftHeight, rightHeight)
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
