class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights.length == 0 || heights == null){
            return res;
        }
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i = 0; i < m; i++){
            dfs(i, 0, pacific, heights);//left
            dfs(i, n-1, atlantic, heights);//right
        }
        for(int j = 0; j < n; j++){
            dfs(0, j, pacific, heights);//up
            dfs(m-1, j, atlantic, heights);//down
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    
    public void dfs(int i, int j, boolean[][] visited, int[][] heights){
        int m = heights.length;
        int n = heights[0].length;
        visited[i][j] = true;
        int[][] dirs = {{1,0}, {-1,0}, {0,1},{0,-1}};
        for(int[] dir : dirs){
            int xi = i + dir[0];
            int yj = j + dir[1];
            if(xi >= m || xi < 0 || yj >= n || yj < 0){
                continue;
            }
            if(visited[xi][yj] == true){
                continue;
            }
            if(heights[xi][yj] < heights[i][j]){
                continue;
            }
            dfs(xi, yj, visited, heights);
        }
    }
}
