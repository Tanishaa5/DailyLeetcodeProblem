import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums); // Sorting is necessary to handle duplicates
        findsub(nums, 0, current, result);
        return result;
    }

    public static void findsub(int[] nums, int i, List<Integer> current, List<List<Integer>> result) {
        // Base case
        if (i == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include current element
        current.add(nums[i]);
        findsub(nums, i + 1, current, result);
        current.remove(current.size() - 1);

        // Skip duplicate elements
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        // Exclude current element and move forward
        findsub(nums, i + 1, current, result);
    }
}
