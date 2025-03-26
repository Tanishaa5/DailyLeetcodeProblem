class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
        findcomb(candidates,target-candidates[i],i+1,result,current);
        //wapas ayega jab 
        //explore different combination
        current.remove(current.size()-1);
        }
           while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++;
        
       
        findcomb(candidates,target,i+1,result,current);

    }
}