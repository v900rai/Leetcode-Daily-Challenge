class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true; // direction control

        while (!queue.isEmpty()) {
            int size = queue.size();

            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // 🔥 Zigzag logic
                if (leftToRight) {
                    level.addLast(node.val); // normal
                } else {
                    level.addFirst(node.val); // reverse
                }

                // children add karo
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);

            // direction flip
            leftToRight = !leftToRight;
        }

        return result;
    }
}