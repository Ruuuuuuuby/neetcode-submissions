// class Solution {//fresh, time, size, rotted, size是为了逐层（逐秒）扩展，不然q不为空一下子就rotted完了
//     public int orangesRotting(int[][] grid) {
//         int fresh = 0;
//         Queue<int[]> q = new LinkedList<>();
//         int m = grid.length;
//         int n = grid[0].length;
//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 if(grid[i][j] == 2){
//                     q.offer(new int[]{i, j});
//                 }
//                 if(grid[i][j] == 1){
//                     fresh++;
//                 }
//             }
//         }
//         int time = 0;
//         int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
//         while(!q.isEmpty()){
//             int size = q.size();
//             boolean rotted = false;
//             for(int i = 0; i < size; i++){
//                 int[] cur = q.poll();
//                 int x = cur[0];
//                 int y = cur[1];
//                 for(int[] dir : dirs){
//                     int xi = x + dir[0];
//                     int yj = y + dir[1];
//                     if(xi >= 0 && xi < m && yj >= 0 && yj < n && grid[xi][yj] == 1){
//                         grid[xi][yj] = 2;
//                         q.offer(new int[]{xi, yj});
//                         fresh--;
//                         rotted = true;
//                     }
//                 }
//             }
//             if(rotted){
//                 time++;
//             }
//         }
//         return fresh == 0 ? time : -1;
//     }
// }

class Solution{
    public int orangesRotting(int[][] grid){
        int fresh = 0;
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                for(int[] direction : directions){
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] != 1){
                        continue;
                    }
                    fresh--;
                    grid[newRow][newCol] = 2;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
            time++;
            if(fresh == 0){
                return time;
            }
        }
        return -1;
    }
}

