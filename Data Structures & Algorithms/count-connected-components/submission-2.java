// class Solution {
//     public int countComponents(int n, int[][] edges) {
//         int[] parent = new int[n];
//         for(int i = 0; i < n; i++){
//             parent[i] = i;
//         }
//         int count = n;
//         for(int[] edge : edges){
//             int x = find(parent, edge[0]);
//             int y = find(parent, edge[1]);
//             if(x != y){
//                 count--;
//                 parent[x] = y;
//             }
//         }
//         return count;
//     }
//     public int find(int[] parent, int x){
//         if(parent[x] != x){
//             parent[x] = find(parent, parent[x]);
//         }
//         return parent[x];
//     }
       
// }

class Solution{
    public int countComponents(int n, int[][] edges){
        int count = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(visited, graph, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(boolean[] visited, List<List<Integer>> graph, int node){
        if(visited[node]){
            return;
        }else{
            visited[node] = true;
            for(int nei : graph.get(node)){
                dfs(visited, graph, nei);
            }
        }
    }
}
