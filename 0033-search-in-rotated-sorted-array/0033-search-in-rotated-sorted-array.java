class Solution {
    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If target is found at mid
            if (arr[mid] == target) {
                return mid;
            }

            // Check which half is sorted
            if (arr[start] <= arr[mid]) { // Left half is sorted
                if (arr[start] <= target && target < arr[mid]) {
                    end = mid - 1; // Target is in the left half
                } else {
                    start = mid + 1; // Target is in the right half
                }
            }
            
            
             else { // Right half is sorted
                if (arr[mid] < target && target <= arr[end]) {
                    start = mid + 1; // Target is in the right half
                } else {
                    end = mid - 1; // Target is in the left half
                }
            }
        }
        
        return -1; // Target not found
    }
}
