import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        int[][] result = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the result grid and enqueue all water cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j}); // Add water cell to the queue
                } else {
                    result[i][j] = -1; // Mark land cells as unvisited
                }
            }
        }

        // Directions for moving up, down, left, and right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check if the neighbor is within bounds and unvisited
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && result[newX][newY] == -1) {
                    result[newX][newY] = result[x][y] + 1; // Update height
                    queue.offer(new int[]{newX, newY}); // Enqueue the cell
                }
            }
        }

        return result;
    }
}
