class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            int u = -1;
            for(int j = 0; j < n; j++){
                if(!visited[j] && (u == -1 || dist[j] < dist[u])){
                    u = j;
                }
            }

            visited[u] = true;
            res += dist[u];

            for(int v = 0; v < n; v++){
                if(!visited[v]){
                    int d = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    dist[v] = Math.min(dist[v], d);
                }
            }
        }
        return res;

        
    }
}
