class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int time = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                for(int[] dir : dirs){
                    int xi = x + dir[0];
                    int yj = y + dir[1];
                    if(xi >= 0 && xi < m && yj >= 0 && yj < n && grid[xi][yj] == 1){
                        grid[xi][yj] = 2;
                        q.offer(new int[]{xi, yj});
                        fresh--;
                        rotted = true;
                    }
                }
            }
            if(rotted){
                time++;
            }
        }
        return fresh == 0 ? time : -1;
    }
}
