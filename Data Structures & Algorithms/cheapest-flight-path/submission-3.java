class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new List[n];//
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] f : flights){
            graph[f[0]].add(new int[]{f[1], f[2]});
        }

        // List<List<int[]>> graph = new ArrayList<>();
        // for(int i = 0; i < n; i++){
        //     graph.get(i) = new ArrayList<>();
        // }
        // for(int[] f : flights){
        //     graph.get(f[0]).add(new int[]{f[1], f[2]});
        // }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0, 0});//city，price，stops

        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int from = cur[0];
            int price = cur[1];
            int stops = cur[2];
            if(from == dst){
                return price;
            }
            if(stops > k || stops > minStops[from]){
                continue;
            }
            minStops[from] = stops;
            for(int[] g : graph[from]){
                int to = g[0];
                int newPrice = g[1];
                pq.offer(new int[]{to, price + newPrice, stops + 1});
            }

        }
        return -1;
    }
}
