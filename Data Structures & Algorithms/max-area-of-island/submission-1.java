class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(i, j, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
    public int dfs(int i, int j, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 ){
            return 0;
        }
        int area = 1;
        grid[i][j] = 0;
        area += dfs(i + 1, j, grid);
        area += dfs(i - 1, j, grid);
        area += dfs(i, j + 1, grid);
        area += dfs(i, j - 1, grid);
        return area;

    }
}
