class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        
        if(m == 0 || matrix == null){
            return 0;
        }
        int res = 0;
        int[][] cache = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, dfs(matrix, i, j, cache));
            }
        } 
        return res;  
    }
    public int dfs(int[][] matrix, int i, int j, int[][] cache){
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        int max = 1;
            for(int[] dir : dirs){
                int x = i + dir[0];
                int y = j + dir[1];
                if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]){
                    max = Math.max(max, 1 + dfs(matrix, x, y, cache));
                }

            }
            cache[i][j] = max;
            return max;
        
    }
}
