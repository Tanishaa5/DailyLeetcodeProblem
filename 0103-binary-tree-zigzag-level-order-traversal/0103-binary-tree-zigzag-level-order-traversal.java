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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List <List<Integer>> result=new ArrayList<>();
         if(root==null){
            return result;
         }
         Stack <TreeNode> leftToRight=new Stack<>();
         Stack <TreeNode> rightToLeft=new Stack<>();
         

         leftToRight.push(root);

         while(!leftToRight.isEmpty() || !rightToLeft.isEmpty()){
            List <Integer> level=new ArrayList<>();
            while(!leftToRight.isEmpty()){
                TreeNode node=leftToRight.pop();
                level.add(node.val);

                if(node.left!=null){
                    rightToLeft.push(node.left);
                }
                if(node.right!=null){
                    rightToLeft.push(node.right);
                }
            }
            if (!level.isEmpty()) result.add(level);

            //reinitialize level
            level=new ArrayList<>();
            
         
            
            while(!rightToLeft.isEmpty()){
                TreeNode node=rightToLeft.pop();
                level.add(node.val);

                if(node.right!=null){
                    leftToRight.push(node.right);
                }
                if(node.left!=null){
                    leftToRight.push(node.left);
                }
               
            }
           if (!level.isEmpty()) result.add(level);
           

            
         
        
        
    }
     return result;
}
}