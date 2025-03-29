class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int col=board[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0) && dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;

        
    }
    public static boolean dfs(char[][]board,String word,int i,int j,int index){
        //base case
        if(index==word.length()){
            return true;

        }
        // ❌ Invalid cases: Out of bounds OR mismatch
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
        return false;
    }
    char temp=board[i][j];
    board[i][j]='#';//mark as visited

    boolean found = dfs(board, word, i + 1, j, index + 1) ||  // Down
                    dfs(board, word, i - 1, j, index + 1) ||  // Up
                    dfs(board, word, i, j + 1, index + 1) ||  // Right
                    dfs(board, word, i, j - 1, index + 1);    // Left

    // \U0001f504 Backtrack (Restore original character)
    board[i][j] = temp;

    return found;



        //recursive function



    }
}