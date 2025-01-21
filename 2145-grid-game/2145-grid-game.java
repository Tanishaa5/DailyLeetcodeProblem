class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        // Step 1: Calculate prefix sums for both rows
        long[] topPrefix = new long[n];
        long[] bottomPrefix = new long[n];
        
        topPrefix[0] = grid[0][0];
        bottomPrefix[0] = grid[1][0];
        
        for (int i = 1; i < n; i++) {
            topPrefix[i] = topPrefix[i - 1] + grid[0][i];
            bottomPrefix[i] = bottomPrefix[i - 1] + grid[1][i];
        }
        
        // Step 2: Calculate the minimum score Player 2 can achieve
        long result = Long.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            // Score if Player 1 switches from row 1 to row 2 at column i
            long scoreTop = topPrefix[n - 1] - topPrefix[i]; // Remaining top row score
            long scoreBottom = (i > 0) ? bottomPrefix[i - 1] : 0; // Already taken bottom row score
            
            // Player 2's best possible score after Player 1's move
            long player2Score = Math.max(scoreTop, scoreBottom);
            
            // Update the minimum Player 2 score
            result = Math.min(result, player2Score);
        }
        
        return result;
    }
}
