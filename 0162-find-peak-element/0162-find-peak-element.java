class Solution{
    public int findPeakElement(int[] nums) {
    int left = 0, right = nums.length - 1;
    
    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[mid + 1]) { 
            right = mid; // Peak is in the left half or at mid
        } else { 
            left = mid + 1; // Peak is in the right half
        }
    }
    
    return left; // `left` and `right` will converge to a peak
}
}
