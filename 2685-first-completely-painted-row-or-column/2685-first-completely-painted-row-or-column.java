class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Map each element in the matrix to its (row, col) position
        int[][] position = new int[rows * cols + 1][2]; // +1 for 1-based indexing
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                position[mat[i][j]] = new int[]{i, j};
            }
        }

        // Track counts for each row and column
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        // Process the array `arr`
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int row = position[num][0];
            int col = position[num][1];

            // Increment counts for the corresponding row and column
            rowCount[row]++;
            colCount[col]++;

            // Check if the row or column is fully covered
            if (rowCount[row] == cols || colCount[col] == rows) {
                return i;
            }
        }

        // If no row or column is completely filled, return -1 (shouldn't occur as per problem constraints)
        return -1;
    }
}
