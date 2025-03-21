class Solution {
    public int findKthPositive(int[] arr, int k) {
        int num = 1, i = 0;

        while (k > 0) {  // Keep checking until we find the k-th missing number
            if (i < arr.length && arr[i] == num) {
                i++; // If num exists in arr, move forward
            } else {
                k--; // If num is missing, decrease k
                if (k == 0) return num; // Return when k-th missing number is found
            }
            num++; // Move to the next number
        }
        return -1; // This line will never be reached
    }
}
