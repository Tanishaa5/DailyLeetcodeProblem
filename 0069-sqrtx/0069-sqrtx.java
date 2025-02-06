class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x; // Handle edge cases

        int s = 0, e = x;
        int ans = 0;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            long square = (long) mid * mid; // Prevent integer overflow

            if (square == x) {
                return mid; // Exact square root found
            } else if (square < x) {
                ans = mid; // Store the best approximation
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans; // Return the largest integer <= sqrt(x)
    }
}

