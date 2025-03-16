//class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         // Step 1: Find the maximum pile size (largest eating speed needed)
//         int largest = Integer.MIN_VALUE;
//         for (int i = 0; i < piles.length; i++) {
//             if (piles[i] > largest) {
//                 largest = piles[i];
//             }
//         }

//         // Step 2: Try all speeds from 1 to largest
//         for (int k = 1; k <= largest; k++) {
//             int totalHours = getTotalHours(piles, k); // Compute time needed for speed k

//             if (totalHours <= h) {
//                 return k; // First valid speed found
//             }
//         }
//         return largest; // Edge case, should not reach here
//     }

//     // Helper function to compute total hours required for a given speed k
//     private int getTotalHours(int[] piles, int k) {
//         int hours = 0;
//         for (int pile : piles) {
//             hours += Math.ceil((double) pile / k); // Use ceil to round up
//         }
//         return hours;
//     }

    
// }
//binary search
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = getMaxPile(piles);
        
        while (low < high) {
            int mid = low + (high - low) / 2;//k=mid
            int totalHours = getTotalHours(piles, mid);

            if (totalHours <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low; // The minimum valid speed
    }

    // Helper function to find the pile with maximum no. of bananas
    private int getMaxPile(int[] piles) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }

    // Helper function to calculate total hours required for speed k
    private int getTotalHours(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / k); // Use ceil to round up
        }
        return hours;
    } 
} 

