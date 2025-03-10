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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // अगर subRoot null है, तो यह हमेशा subtree होगा
        if (subRoot == null) {
            return true;
        }

        // अगर main root null हो गया और subRoot अभी भी null नहीं है, तो subtree नहीं हो सकता
        if (root == null) {
            return false;
        }

        // अगर दोनों ट्री समान हैं, तो subRoot एक subtree है
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // बाएं या दाएं subtree में चेक करें
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // यह फंक्शन चेक करेगा कि दो ट्री एक जैसे हैं या नहीं
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
