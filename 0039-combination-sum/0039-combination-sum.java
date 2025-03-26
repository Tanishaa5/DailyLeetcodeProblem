// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         ArrayList<List<Integer>> result = new ArrayList<>();
//         List<Integer> current = new ArrayList<>();
//         helper(0, target, candidates, result, current);
//         return result;
//     }

//     // Helper function
//     public static void helper(int i, int target, int[] candidates, ArrayList<List<Integer>> result, List<Integer> current) {
//         // Base case: If target becomes 0, store the current combination
//         if (target == 0) {
//             result.add(new ArrayList<>(current));
//             return;  // Stop further recursion
//         }

//         // Base case: If index reaches out of bounds
//         if (i == candidates.length) {
//             return;
//         }

//         // Include the current element if it doesn't exceed the target
//         if (candidates[i] <= target) {
//             current.add(candidates[i]);
//             helper(i, target - candidates[i], candidates, result, current);
//             current.remove(current.size() - 1);  // Backtrack
//         }

//         // Exclude the current element and move to the next index
//         helper(i + 1, target, candidates, result, current);
//     }
// }

//the below code is making it inefficient because it is making unnecessary recursive call
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        findcomb(candidates, target, 0, result,current);
        return result;
        
        
    }

    public static void findcomb(int[]candidates,int target,int i,List<List<Integer>> result, List<Integer> current){
        //base case
        if(i==candidates.length){
            if(target==0){
               // result.add(current);//When you add current to result, you're adding a reference to the same current list instead of a new copy of it.
                //Because of this, all lists in result will contain the final modified version of current, instead of storing separate valid combinations.
                 result.add(new ArrayList<>(current));
               
            }
            return;

        }
        //recursive approach 
        if(target>=candidates[i]){
        current.add(candidates[i]);
        findcomb(candidates,target-candidates[i],i,result,current);
        //wapas ayega jab 
        //explore different combination
        current.remove(current.size()-1);//ye andar isliye hai kyunki hume pick wala element ko hi remove karege n
        }
       
        findcomb(candidates,target,i+1,result,current);

    }
}