import java.util.ArrayList;
import java.util.List;

class Solution {

    // Main function to generate subsets
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // To store the final subsets
        List<Integer> current = new ArrayList<>();      // Temporary list for the current subset
        generateSubsets(nums, current, result, 0);      // Start recursion
        return result;
    }

    // Helper function to generate subsets using recursion
    private void generateSubsets(int[] nums, List<Integer> current, List<List<Integer>> result, int index) {
        // Base case: If we've processed all elements, add the current subset to the result
        if (index == nums.length) {
            result.add(new ArrayList<>(current)); // Add a copy of the current list to avoid reference issues
            return;
        }

        // Exclude the current element and move to the next
        generateSubsets(nums, current, result, index + 1);

        // Include the current element in the subset
        current.add(nums[index]);

        // Recurse for the next element
        generateSubsets(nums, current, result, index + 1);

        // Backtrack: Remove the last element to undo the choice
        current.remove(current.size() - 1);
    }
}
