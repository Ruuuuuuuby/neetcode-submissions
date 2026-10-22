// // class Solution {
// //     //计算到每个点的最短到达时间，返回最短时间中的最大值（覆盖所有点）
// //     public int networkDelayTime(int[][] times, int n, int k) {
// //         List<List<int[]>> graph = new ArrayList<>();
// //         for(int i = 0; i <= n; i++){
// //             graph.add(new ArrayList<>());//!!!!!
// //         }
// //         for(int[] edge : times){
// //             int u = edge[0];
// //             int v = edge[1];
// //             int w = edge[2];
// //             graph.get(u).add(new int[]{v, w});
// //         }

// //         int[] dis = new int[n + 1];
// //         Arrays.fill(dis, Integer.MAX_VALUE);//!!!!!!!
// //         dis[k] = 0;//!!!!
// //         PriorityQueue<int[]> pq = new PriorityQueue<>((a ,b) -> a[1] - b[1]);
// //         pq.offer(new int[]{k, 0});
// //         while(!pq.isEmpty()){
// //             int[] cur = pq.poll();
// //             int u = cur[0];
// //             int time = cur[1];
// //             if(time > dis[u]){
// //                 continue;
// //             }
// //             for(int[] g : graph.get(u)){
// //                 int v = g[0];
// //                 int w = g[1];
// //                 if(dis[v] > dis[u] + w){
// //                     dis[v] = dis[u] + w;
// //                     pq.offer(new int[]{v, dis[v]});
// //                 }     
// //             }
// //         }
// //         int res = 0;
// //         for(int i = 1; i <= n; i++){
// //             if(dis[i] == Integer.MAX_VALUE){
// //                 return -1;
// //             }
// //             res = Math.max(res, dis[i]);
// //         }
// //         return res;
// //     }
// // }

// class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {

//         // Step 1: Build adjacency list
//         Map<Integer, List<int[]>> graph = new HashMap<>();

//         for (int[] time : times) {
//             int u = time[0];
//             int v = time[1];
//             int w = time[2];

//             graph.computeIfAbsent(u, x -> new ArrayList<>())
//                  .add(new int[]{v, w});
//         }

//         // Step 2: Initialize distances
//         int[] dist = new int[n + 1];
//         Arrays.fill(dist, Integer.MAX_VALUE);

//         dist[k] = 0;

//         // Step 3: Min Heap
//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//             (a, b) -> Integer.compare(a[1], b[1])
//         );

//         pq.offer(new int[]{k, 0});

//         // Step 4: Dijkstra
//         while (!pq.isEmpty()) {

//             int[] cur = pq.poll();

//             int node = cur[0];
//             int distance = cur[1];

//             if (distance > dist[node]) {
//                 continue;
//             }

//             for (int[] neighbor :
//                     graph.getOrDefault(node, Collections.emptyList())) {

//                 int nextNode = neighbor[0];
//                 int weight = neighbor[1];

//                 int newDist = distance + weight;

//                 if (newDist < dist[nextNode]) {

//                     dist[nextNode] = newDist;

//                     pq.offer(new int[]{nextNode, newDist});
//                 }
//             }
//         }

//         // Step 5: Find maximum shortest distance
//         int result = 0;

//         for (int i = 1; i <= n; i++) {

//             if (dist[i] == Integer.MAX_VALUE) {
//                 return -1;
//             }

//             result = Math.max(result, dist[i]);
//         }

//         return result;
//     }
// }



class Solution{
    public int networkDelayTime(int[][] times, int n, int k){
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, w});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{k, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int distance = cur[1];
            if(distance > dist[node]){
                continue;
            }
            for(int[] neighbor : graph.getOrDefault(node, Collections.emptyList())){
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = distance + weight;
                if(newDist < dist[nextNode]){
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(res, dist[i]);
        }
        return res;


    }
}