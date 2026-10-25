// class Solution {
//     public boolean exist(char[][] board, String word) {
//         for(int i = 0; i < board.length; i++){
//             for(int j = 0; j < board[0].length; j++){
//                 if(dfs(board, word, i, j, 0)){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }

//     public boolean dfs(char[][] board, String word, int i, int j, int idx){
//         if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
//             return false;
//         }
//         if(board[i][j] != word.charAt(idx)){
//             return false;
//         }
//         if(idx == word.length() - 1){
//             return true;
//         }
//         char temp = board[i][j];
        
//         board[i][j] = '#';//已访问

//         boolean found = (dfs(board, word, i+1, j, idx+1) || dfs(board, word, i-1, j, idx+1) || dfs(board, word, i, j+1, idx+1) || dfs(board, word, i, j-1, idx+1));
//         board[i][j] = temp;
//         return found;
//     }
// }

// class Solution{
//     public boolean exist(char[][] board, String word){
//         for(int i = 0; i < board.length; i++){
//             for(int j = 0; j < board[0].length; j++){
//                 if(dfs(board, word, i, j, 0)){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }

//     public boolean dfs(char[][] board, String word, int i, int j, int idx){
//         if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
//             return false;
//         }
//         if(board[i][j] != word.charAt(idx)){
//             return false;
//         }
//         if(idx == word.length() - 1){
//             return true;
//         }
//         char c = board[i][j];
//         board[i][j] = '#';
//         boolean found = dfs(board, word, i - 1, j, idx + 1) || dfs(board, word, i + 1, j, idx + 1) || dfs(board, word, i, j + 1, idx + 1) || dfs(board, word, i, j - 1, idx + 1);
//         board[i][j] = c;
//         return found;
//     }//boolean dfs可以直接在dfs内部判断出不出界
// }

class Solution{

    public boolean exist(char[][] board, String word){
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int idx){
        int m = board.length;
        int n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(idx)){
            return false;
        }
        if(idx == word.length() - 1){
            return true;
        }
        char c = board[i][j];
        board[i][j] = '#';
        boolean found = dfs(board, word, i - 1, j, idx + 1) || dfs(board, word, i + 1, j, idx + 1) || dfs(board, word, i, j - 1, idx + 1) || dfs(board, word, i, j + 1, idx + 1);
        board[i][j] = c;
        return found;
    }

}
