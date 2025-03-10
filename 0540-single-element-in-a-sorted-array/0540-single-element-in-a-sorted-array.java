class Solution {
    public int singleNonDuplicate(int[] nums) {
    int s = 0, e = nums.length - 1;
    
    while (s < e) {
        int mid = s + (e - s) / 2;
        
        // Ensure mid is even (to check pairs properly)
        if (mid % 2 == 1) {
            mid--;
        }

        // If mid and mid+1 are the same, the single element is in the right half
        if (nums[mid] == nums[mid + 1]) {
            s = mid + 2;  // Move right
        } else {
            e = mid;      // Move left
        }
    }

    // s will point to the single non-duplicate element
    return nums[s];
}
}
