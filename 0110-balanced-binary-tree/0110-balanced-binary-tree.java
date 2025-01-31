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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true; // Base case: Empty tree is balanced
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        // Check height difference condition
        if (Math.abs(leftHeight - rightHeight) > 1) return false;

        // Recursively check for left and right subtrees
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int lefth=height(node.left);
        int righth=height(node.right);
        return Math.max(lefth, righth) + 1;
    }
}
