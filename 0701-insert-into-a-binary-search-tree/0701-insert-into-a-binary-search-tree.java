class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        // Base case: agar tree empty hai to new node return karo
        if (root == null) {
            return new TreeNode(val);
        }
        
        // Agar value choti hai root se -> left subtree me insert
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        // Agar value badi hai root se -> right subtree me insert
        else {
            root.right = insertIntoBST(root.right, val);
        }
        
        // Root ko wapas return karna zaroori hai
        return root;
    }
}
