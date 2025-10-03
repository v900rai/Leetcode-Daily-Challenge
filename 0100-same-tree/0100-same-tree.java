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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // अगर दोनों नोड null हैं, तो ट्री समान हैं
        if(p == null && q == null){
          return true;
        }

        // अगर कोई एक नोड null है और दूसरा नहीं, तो ट्री अलग हैं
        if (p == null || q == null) {
            return false;
        }

        // अगर दोनों नोड्स का वैल्यू अलग है, तो ट्री अलग हैं
        if (p.val != q.val) {
            return false;
        }

        // बाएं और दाएं सब-ट्री को चेक करें
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
