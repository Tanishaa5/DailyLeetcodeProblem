import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        // Edge case: If the grid is too small to trap water
        if (m < 3 || n < 3) return 0;

        // Priority Queue to process cells in ascending height order
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Visited array to track processed cells
        boolean[][] visited = new boolean[m][n];

        // Add all boundary cells to the heap
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        // Directions for moving up, down, left, and right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int trappedWater = 0;

        // Process cells in the min-heap
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            // Check all four neighbors
            for (int[] dir : directions) {
                int newRow = cell.row + dir[0];
                int newCol = cell.col + dir[1];

                // Skip if the cell is out of bounds or already visited
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                    continue;
                }

                // Calculate trapped water
                trappedWater += Math.max(0, cell.height - heightMap[newRow][newCol]);

                // Update the neighbor's height to the max of current boundary and its original height
                pq.offer(new Cell(newRow, newCol, Math.max(cell.height, heightMap[newRow][newCol])));
                visited[newRow][newCol] = true;
            }
        }

        return trappedWater;
    }

    // Helper class to represent a cell in the grid
    private static class Cell {
        int row, col, height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
