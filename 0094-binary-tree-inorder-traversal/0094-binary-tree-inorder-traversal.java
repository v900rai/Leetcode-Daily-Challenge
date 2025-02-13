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
      List<Integer> list=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        
        // if(root==null) 
        // return list;
        // inorderTraversal(root.left);
        // list.add(root.val);
        // inorderTraversal(root.right);
        // return list;


    //normal function has been created
        List<Integer> res=new ArrayList<>();

        inorder(root, res);
        return res;        
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }    

}