/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { 
 *         val = x; 
 *     }
 * }
 */

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Traverse the tree starting from root
        while (root != null) {

            // Case 1: If both p and q are smaller than root
            // Hindi: agar p aur q dono root se chhote hain
            // then LCA will be in left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left; // move left
            }

            // Case 2: If both p and q are greater than root
            // Hindi: agar p aur q dono root se bade hain
            // then LCA will be in right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right; // move right
            }

            // Case 3: We found the split point
            // Hindi: ek left me hai aur ek right me (ya root hi LCA hai)
            // This is the Lowest Common Ancestor
            else {
                return root;
            }
        }

        // If tree is empty or no LCA found
        return null;
    }
}