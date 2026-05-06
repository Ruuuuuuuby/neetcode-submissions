class Solution {
    
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0,1}, {0,-1}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int[] dir : dirs){
                int xi = x + dir[0];
                int yj = y + dir[1];
                if(xi >= 0 && xi < m && yj >= 0 && yj < n && grid[xi][yj] == 2147483647){
                    grid[xi][yj] = grid[x][y] + 1;
                    q.offer(new int[]{xi, yj});
                }
            }
        } 
    }
}
