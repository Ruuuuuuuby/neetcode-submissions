class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        int n = grid.length;
        int res = 0;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int height = cur[0];
            int i = cur[1];
            int j = cur[2];
            res = Math.max(res, height);//!!!!!!!!!!!
            if(i == n - 1 && j == n - 1){
                return res;
            }
            for(int[] dir : dirs){
                int xi = dir[0] + i;
                int yj = dir[1] + j;
                if(xi >= 0 && xi < n && yj >= 0 && yj < n && !visited[xi][yj]){
                    pq.offer(new int[]{grid[xi][yj], xi, yj});
                    visited[xi][yj] = true;
                }
            }
            
        }
        return -1;
        
    }
}
