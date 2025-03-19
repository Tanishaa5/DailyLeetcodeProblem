

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((m * k) > bloomDay.length) {
            return -1;  // Not enough flowers to make bouquets
        }

        // Find min and max days in bloomDay
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        // Binary Search
        int s = min, e = max, ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                ans = mid;  // Possible answer
                e = mid - 1;  // Try for a smaller day
            } else {
                s = mid + 1;  // Increase days
            }
        }
        return ans;
    }

    // Helper function to check if we can make 'm' bouquets on 'currentDay'
    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int currentDay) {
        int count = 0, bouquets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= currentDay) {
                count++;
                if (count == k) {  // If we have enough adjacent flowers, form a bouquet
                    bouquets++;
                    count = 0;
                    if (bouquets == m) return true;  // Stop early
                }
            } else {
                count = 0;  // Reset if non-adjacent
            }
        }
        return bouquets >= m;
    }
}
