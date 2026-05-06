class Solution {//minCost[]   res
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new List[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] f : flights){
            graph[f[0]].add(new int[]{f[1], f[2]});
        }
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});
        int res = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int u = cur[0];
            int cost = cur[1];
            int stops = cur[2];
            if(u == dst){
                res = Math.min(cost, res);
                continue;
            }
            if(stops > k){
                continue;
            }
            for(int[] e : graph[u]){
                int v = e[0];
                int w = e[1];
                if(minCost[v] > cost + e[1]){
                    q.offer(new int[]{v, cost + e[1], stops + 1});
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;

    }
}
