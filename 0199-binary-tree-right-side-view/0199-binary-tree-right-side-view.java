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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;  // If the tree is empty, return an empty list
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);  // Start with the root node

        while (!q.isEmpty()) {
            int levelSize = q.size();  // Number of nodes at the current level

            // Traverse all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();

                // If this is the rightmost node of the level, add it to the result
                if (i == levelSize - 1) {
                    result.add(node.val);
                }

                // Add the children of the current node to the queue
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return result;
    }
}
