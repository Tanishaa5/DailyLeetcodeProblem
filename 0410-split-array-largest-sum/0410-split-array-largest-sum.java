class Solution {
    public int splitArray(int[] nums, int k) {
        // Define the range
        int s = max(nums); // Get the max value in the array
        int e = sum(nums); // Get the sum of all elements in the array
        int ans = 0;
        int n = nums.length;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (canSplit(nums, mid, k, n)) {
                ans = mid;
                e = mid - 1; // Try to minimize the max sum
            } else {
                s = mid + 1; // Increase the limit
            }
        }
        return ans;
    }

    // Function to calculate the sum of all elements in the array
    public static int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    // Function to find the maximum element in the array
    public static int max(int[] nums) {
        int max = Integer.MIN_VALUE; // Initialize max properly
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Function to check if we can split the array into k subarrays with max sum ≤ mid
    public static boolean canSplit(int[] nums, int mid, int k, int n) {
        int count = 1; // We always have at least 1 part
        int allocated = 0;

        for (int num : nums) {
            if (allocated + num <= mid) {
                allocated += num;
            } else {
                count++;
                if (count > k) {
                    return false; // More splits than allowed
                }
                allocated = num;
            }
        }
        return true;
    }
}
