class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];
        dfs(res, board, col, diag1, diag2, 0);
        return res;
        
    }
    public void dfs(List<List<String>> res, char[][] board, boolean[] col, boolean[] diag1, boolean[] diag2, int row){
        if(row == board.length){
            List<String> temp = new ArrayList<>();
            for(char[] r : board){
                temp.add(new String(r));
            }
            res.add(temp);
            return;
        }
        for(int i = 0; i < board.length; i++){
            if(col[i] || diag1[row + i] || diag2[row - i + board.length]){
                continue;
            }
            board[row][i] = 'Q';
            col[i] = diag1[row + i] = diag2[row - i + board.length] = true;
            
            dfs(res, board, col, diag1, diag2, row + 1);

            board[row][i] = '.';
            col[i] = diag1[row + i] = diag2[row - i + board.length] = false;
            

        }

    }
}
