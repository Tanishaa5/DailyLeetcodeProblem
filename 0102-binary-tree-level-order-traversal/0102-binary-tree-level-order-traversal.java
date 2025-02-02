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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;//return empty list because empty tree
        }
        Queue <TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelsize=queue.size();//current level

            List <Integer> level=new ArrayList<>();
            for(int i=0;i<levelsize;i++){
                TreeNode node=queue.poll();
                
                // if (i == levelsize-1) { //last node
                //                        //(i==0)// First node of this level (leftmost)
                //     level.add(node.val);
                // }

                 level.add(node.val);

                if(node.left!=null){
                    queue.add(node.left);//adding left children
                }
                if(node.right!=null){
                    queue.add(node.right);//adding right children
                }


            }
            result.add(level);

        }
        return result;


        
        
    }

    
}