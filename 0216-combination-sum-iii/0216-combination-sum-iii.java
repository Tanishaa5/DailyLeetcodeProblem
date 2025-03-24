import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        findcomb(1, k, n, result, new ArrayList<>());
        return result;
    }

    private void findcomb(int start, int k, int n, List<List<Integer>> result, List<Integer> current) {
        // Base Case: If we found a valid combination
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(current)); // Add a copy of the list
            return;
        }

        // If n becomes negative or we use more numbers than allowed, stop recursion
        if (n < 0 || k < 0) return;

        // Try numbers from 'start' to 9
        for (int i = start; i <= 9; i++) {
            current.add(i); // Pick the number
            findcomb(i + 1, k - 1, n - i, result, current); // Recur with reduced values
            current.remove(current.size() - 1); // Backtrack: remove last added number
        }
    }

}
