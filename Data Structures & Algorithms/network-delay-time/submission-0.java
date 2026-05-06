class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());//!!!!!
        }
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new int[]{v, w});
        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);//!!!!!!!
        dis[k] = 0;//!!!!
        PriorityQueue<int[]> pq = new PriorityQueue<>((a ,b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[0];
            int time = cur[1];
            if(time > dis[u]){
                continue;
            }
            for(int[] g : graph.get(u)){
                int v = g[0];
                int w = g[1];
                if(dis[v] > dis[u] + w){
                    dis[v] = dis[u] + w;
                    pq.offer(new int[]{v, dis[v]});
                }     
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++){
            if(dis[i] == Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(res, dis[i]);
        }
        return res;
    }
}
