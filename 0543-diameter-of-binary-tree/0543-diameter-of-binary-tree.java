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
    int diameter; // ग्लोबल वेरिएबल जो अधिकतम डायमीटर स्टोर करेगा

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0; // डायमीटर को 0 से इनिशियलाइज़ करें
        depth(root); // हेल्पर फंक्शन को कॉल करें
        return diameter; // फाइनल डायमीटर रिटर्न करें
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0; // यदि नोड null है, तो उसकी गहराई 0 होगी
        }

        // बाएं और दाएं सब-ट्री की गहराई निकालें
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // डायमीटर को अपडेट करें (leftDepth + rightDepth = सबसे लंबा path)
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // करंट नोड की गहराई = (1 + अधिकतम(leftDepth, rightDepth))
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
