

class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        // Mark numbers as visited by making nums[index] negative
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1; // Convert value to index
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Mark as visited
            }
        }

        // Find indices that are still positive (missing numbers)
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // Missing number
            }
        }

        return result;
    }

    
}




// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         ArrayList<Integer> result=new ArrayList<>();

//         HashSet<Integer> set=new HashSet<>();
//         for(int i=0;i<nums.length;i++){
//             set.add(nums[i]);

//         }

//         for(int i=1;i<=nums.length;i++){
//             if(!set.contains(i)){
//                 result.add(i);
//             }
//         }
//         return result;
        
//     }
// }