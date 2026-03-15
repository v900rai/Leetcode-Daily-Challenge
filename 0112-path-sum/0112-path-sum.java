class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Agar tree empty hai
        if (root == null) {
            return false;
        }

        // Agar leaf node hai, check karo targetSum match karta hai ya nahi
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Left ya right subtree me remaining sum check karo
        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
}