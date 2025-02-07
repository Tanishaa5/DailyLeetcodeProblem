class Solution {
    public int findPeakElement(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            // Handle edge cases and general case:
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && 
                (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return mid; // Found a peak
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                e = mid - 1; // Peak is to the left
            } else {
                s = mid + 1; // Peak is to the right
            }
        }
        return -1; // No peak found (shouldn't happen in a valid peak array)
    }
}
