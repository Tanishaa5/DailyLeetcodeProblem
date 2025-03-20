class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Find minimum capacity (heaviest package)
        int mincap = 0;
        for (int weight : weights) {
            mincap = Math.max(mincap, weight);
        }

        // Find maximum capacity (sum of all weights)
        int maxcap = 0;
        for (int weight : weights) {
            maxcap += weight;
        }

        // Binary Search
        int s = mincap;
        int e = maxcap;
        int ans = maxcap; // Store potential answer

        while (s <= e) {
            int mid = s + (e - s) / 2;
            
            if (canShipInDays(weights, days, mid)) {
                ans = mid; // Update answer
                e = mid - 1; // Try smaller capacity
            } else {
                s = mid + 1; // Increase capacity
            }
        }

        return ans;
    }

    // Helper function to check if we can ship within 'days' with given 'capacity'
    private boolean canShipInDays(int[] weights, int days, int capacity) {
        int dayCount = 1; // Start with day 1
        int currentLoad = 0;

        for (int weight : weights) { 
            currentLoad += weight;  // Add weight

            if (currentLoad > capacity) { // If exceeds capacity
                dayCount++; // Move to next day
                currentLoad = weight; // Start new day with current package
            }

            if (dayCount > days) return false; // More days needed than allowed
        }

        return true; // Successfully shipped within days
    }
}
