class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] visited = new boolean[n];
        dfs(0, -1, visited, graph);
        for(boolean v : visited){
            if(!v){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int cur, int parent, boolean[] visited, List<List<Integer>> graph){//dfs true 无环
        visited[cur] = true;
        for(int g : graph.get(cur)){
            if(g == parent){
                continue;
            }
            if(visited[g] || !dfs(g, cur, visited, graph)){
                return false;
            }
        }
        return true;

    }
}
