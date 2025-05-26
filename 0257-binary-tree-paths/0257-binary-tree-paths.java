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
public List<String> binaryTreePaths(TreeNode root) {
    ArrayList<String> res = new ArrayList<String>();        
    DFS(root, "", res);
    return res;        
}
	
public void DFS(TreeNode root, String solution, ArrayList<String> res) {
	if (root == null) return;    	
	if (root.left==null && root.right==null) res.add(solution + root.val);
	DFS(root.left, solution + root.val + "->", res);    	
	DFS(root.right, solution + root.val + "->", res);    	    	
}
}