class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Compare current element with the next (using modulo for circular comparison)
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            // If more than one descending break, return false
            if (count > 1) {
                return false;
            }
        }

        // Array is sorted and rotated if there's at most one descending break
        return true;
    }
}
