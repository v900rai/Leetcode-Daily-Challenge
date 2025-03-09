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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // हर कॉल के लिए नई लिस्ट
        postorderHelper(root, list);
        return list;
    }

    private void postorderHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorderHelper(root.left, list);
        postorderHelper(root.right, list);
        list.add(root.val);
    }
}
