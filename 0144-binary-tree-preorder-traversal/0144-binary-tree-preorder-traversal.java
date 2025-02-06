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
//  */
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {

//         List <Integer> result=new ArrayList<>();
//         traverse(root,result);
//         return result;
//     }

//         private void traverse(TreeNode root,List<Integer> result){
//         if(root==null){
//             return;
//         }
//        result.add(root.val);
//        traverse(root.left,result);
//        traverse(root.right,result);

        
    
// }
// }

//iterative
class Solution{

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

    
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);

            // Push right first so that left is processed first
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }

        return result;
    }
    }