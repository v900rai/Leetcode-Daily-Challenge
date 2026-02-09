import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        // Final answer list
        List<List<Integer>> result = new ArrayList<>();
        
        // Agar tree empty hai
        if(root == null) return result;
        
        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        // Jab tak queue empty na ho
        while(!queue.isEmpty()){
            
            int size = queue.size(); // current level ka size
            List<Integer> level = new ArrayList<>();
            
            // Har level ke nodes process karo
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                
                level.add(current.val); // node value add
                
                // left child
                if(current.left != null)
                    queue.add(current.left);
                
                // right child
                if(current.right != null)
                    queue.add(current.right);
            }
            
            // current level ko result me add karo
            result.add(level);
        }
        
        return result;
    }
}
