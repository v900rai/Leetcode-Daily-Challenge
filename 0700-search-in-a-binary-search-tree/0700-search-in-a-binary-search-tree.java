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
    public TreeNode searchBST(TreeNode root, int val) {
        // base case bhaut important hota i recursions m yrr
      if(root==null){
        return root;

      }
      if(root.val==val){
        return root;
      }
      if(root.val>val){
       return searchBST(root.left, val);
      }
      else{
       return  searchBST(root.right, val);
      }
      

    }
}